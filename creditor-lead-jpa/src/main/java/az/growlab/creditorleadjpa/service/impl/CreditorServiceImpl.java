package az.growlab.creditorleadjpa.service.impl;

import az.growlab.creditorleadjpa.dto.LoanRequest;
import az.growlab.creditorleadjpa.dto.PassportInformationRequest;
import az.growlab.creditorleadjpa.dto.PersonalInformationRequest;
import az.growlab.creditorleadjpa.dto.ProductRequest;
import az.growlab.creditorleadjpa.entity.*;
import az.growlab.creditorleadjpa.enums.ActionStatus;
import az.growlab.creditorleadjpa.enums.FinalStatus;
import az.growlab.creditorleadjpa.exception.CustomNotFoundException;
import az.growlab.creditorleadjpa.repository.*;
import az.growlab.creditorleadjpa.service.CreditorService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditorServiceImpl implements CreditorService {
    private final PassportInformationRepository passportInformationRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoanRepository loanRepository;
    @Override
    @Transactional
    public void identityApprove(PassportInformationRequest passportInformationRequest) {
        PassportInformation passportInformation = modelMapper.map(passportInformationRequest,PassportInformation.class);
        passportInformationRepository.save(passportInformation);
        User user = new User(0L,null,passportInformation,
                ActionStatus.WAITING_FOR_IDENTITY_APPROVE, FinalStatus.IN_PROGRESS,null);
        userRepository.save(user);
    }

    @Override
    public void initialApprove(PersonalInformationRequest personalInformationRequest) {
        User user = userRepository.findById(personalInformationRequest.getUserId()).
                orElseThrow(() -> new CustomNotFoundException("User not found"));
        if(!user.getActionStatus().equals(ActionStatus.IDENTITY_CHECK_APPROVED))
            throw new UnsupportedOperationException("Identity check approve required");
        ContactInformation contactInformation = modelMapper.map(personalInformationRequest.getContactInformationRequest(),
                ContactInformation.class);
        AddressInformation addressInformation = modelMapper.map(personalInformationRequest.getAddressInformationRequest(),
                AddressInformation.class);
        user.setPersonalInformation(new PersonalInformation(0L,contactInformation,addressInformation));
        user.setActionStatus(ActionStatus.WAITING_FOR_INITIAL_APPROVE);
        userRepository.save(user);

    }

    @Override
    public void finalApprove(LoanRequest loanRequest) {
        User user = userRepository.findById(loanRequest.getUserId()).
                orElseThrow(() -> new CustomNotFoundException("User not found"));
        if(!user.getActionStatus().equals(ActionStatus.INITIAL_CHECK_APPROVED))
            throw new UnsupportedOperationException("Initial check approve required");
        List<ProductRequest> productRequestList = loanRequest.getProductRequestList();
        Long totalAmount = 0L;
        for(ProductRequest productRequest : productRequestList) {
            totalAmount+=productRequest.getPrice().longValue();
        }
        Loan loan =  modelMapper.map(loanRequest,Loan.class);
        loan.setTotalAmount(BigDecimal.valueOf(totalAmount));
        List<Product> productList = new ArrayList<>();
        for(ProductRequest productRequest : productRequestList) {
            Product product = modelMapper.map(productRequest, Product.class);
            product.setLoan(loan);
            productList.add(product);
        }
        loan.setUser(user);
        loan.setProductList(productList);
        user.setActionStatus(ActionStatus.WAITING_FOR_FINAL_APPROVE);
        loanRepository.save(loan);
    }
}
