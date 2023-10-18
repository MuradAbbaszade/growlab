package az.growlab.creditor_lead.service.impl;

import az.growlab.creditor_lead.domain.*;
import az.growlab.creditor_lead.dto.*;
import az.growlab.creditor_lead.enums.ActionStatus;
import az.growlab.creditor_lead.exception.custom.CustomNotFoundException;
import az.growlab.creditor_lead.repository.*;
import az.growlab.creditor_lead.service.CreditorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditorServiceImpl implements CreditorService {

    private final PassportInformationRepository passportInformationRepository;
    private final UserRepository userRepository;
    private final ActionStatusRepository actionStatusRepository;
    private final FinalStatusRepository finalStatusRepository;
    private final ModelMapper modelMapper;
    private final AddressInformationRepository addressInformationRepository;
    private final ContactInformationRepository contactInformationRepository;
    private final PersonalInformationRepository personalInformationRepository;
    private final LoanRepository loanRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public int savePassportInformation(PassportInformationRequest passportInformationRequest) {
        PassportInformation passportInformation = modelMapper.map(passportInformationRequest, PassportInformation.class);
        Long passportInformationId = passportInformationRepository.save(passportInformation);
        Long actionStatusId = actionStatusRepository.getStatusId("WAITING_FOR_IDENTITY_APPROVE");
        Long finalStatusId = finalStatusRepository.getStatusId("IN_PROGRESS");
        return userRepository.save(new User(0L, null, passportInformationId, finalStatusId, actionStatusId, null));
    }

    @Override
    @Transactional
    public Long saveContactAndAddressInformation(Long userId, PersonalInformationRequest personalInformationRequest) throws CustomNotFoundException {
        ContactInformationRequest contactInformationRequest = personalInformationRequest.getContactInformationRequest();
        AddressInformationRequest addressInformationRequest = personalInformationRequest.getAddressInformationRequest();
        ActionStatus actionStatus = actionStatusRepository.getUserActionStatus(userId);
        if (!actionStatus.equals(ActionStatus.IDENTITY_CHECK_APPROVED))
            throw new CustomNotFoundException("Identity check not found.");
        Long actionStatusId = actionStatusRepository.getStatusId(ActionStatus.WAITING_FOR_INITIAL_APPROVE.toString());
        userRepository.changeUserActionStatus(userId, actionStatusId);
        ContactInformation contactInformation = modelMapper.map(contactInformationRequest, ContactInformation.class);
        AddressInformation addressInformation = modelMapper.map(addressInformationRequest, AddressInformation.class);
        Long addressInformationId = addressInformationRepository.save(addressInformation);
        Long contactInformationId = contactInformationRepository.save(contactInformation);
        return personalInformationRepository.save(new PersonalInformation(userId, addressInformationId, contactInformationId));
    }

    @Override
    @Transactional
    public Long saveLoan(LoanRequest loanRequest) throws CustomNotFoundException {
        ActionStatus actionStatus = actionStatusRepository.getUserActionStatus(loanRequest.getUserId());
        if (!actionStatus.equals(ActionStatus.INITIAL_CHECK_APPROVED))
            throw new CustomNotFoundException("Initial check not found.");
        Long actionStatusId = actionStatusRepository.getStatusId(ActionStatus.WAITING_FOR_FINAL_APPROVE.toString());
        userRepository.changeUserActionStatus(loanRequest.getUserId(), actionStatusId);
        Loan loan = modelMapper.map(loanRequest, Loan.class);
        Long loanId = loanRepository.save(loan);
        List<ProductRequest> productRequestList = loanRequest.getProductRequestList();
        for (ProductRequest productRequest : productRequestList) {
            Product product = modelMapper.map(productRequest, Product.class);
            product.setLoanId(loanId);
            productRepository.save(product);
        }
        return loanId;
    }
}
