package az.growlab.creditor_lead.service.impl;

import az.growlab.creditor_lead.domain.*;
import az.growlab.creditor_lead.dto.AddressInformationRequest;
import az.growlab.creditor_lead.dto.ContactInformationRequest;
import az.growlab.creditor_lead.dto.PassportInformationRequest;
import az.growlab.creditor_lead.enums.ActionStatus;
import az.growlab.creditor_lead.exception.custom.CustomNotFoundException;
import az.growlab.creditor_lead.repository.*;
import az.growlab.creditor_lead.service.CreditorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreditorServiceImpl implements CreditorService {

    private final PassportInformationRepository passportInformationRepository;
    private final UserRepository userRepository;
    private final ActionStatusRepository actionStatusRepository;
    private final FinalStatusRepository finalStatusRepository;
    private final ModelMapper modelMapper;
    private AddressInformationRepository addressInformationRepository;
    private ContactInformationRepository contactInformationRepository;
    private PersonalInformationRepository personalInformationRepository;
    @Override
    @Transactional
    public int savePassportInformation(PassportInformationRequest passportInformationRequest) {
        PassportInformation passportInformation = modelMapper.map(passportInformationRequest, PassportInformation.class);
        Long passportInformationId = passportInformationRepository.save(passportInformation);
        Long actionStatusId = actionStatusRepository.getStatusId("WAITING_FOR_IDENTITY_APPROVE");
        Long finalStatusId = finalStatusRepository.getStatusId("IN_PROGRESS");
        return userRepository.save(new User(0L,null,passportInformationId,finalStatusId,actionStatusId,null));
    }

    @Override
    @Transactional
    public Long saveContactAndAddressInformation(Long userId, ContactInformationRequest contactInformationRequest, AddressInformationRequest addressInformationRequest) throws CustomNotFoundException {
        ActionStatus actionStatus= actionStatusRepository.getUserActionStatus(userId);
        if(!actionStatus.equals(ActionStatus.IDENTITY_CHECK_APPROVED)) throw new CustomNotFoundException("Identity check not found.");
        Long actionStatusId = actionStatusRepository.getStatusId(ActionStatus.WAITING_FOR_INITIAL_APPROVE.toString());
        userRepository.changeUserActionStatus(userId,actionStatusId);
        ContactInformation contactInformation = modelMapper.map(contactInformationRequest,ContactInformation.class);
        AddressInformation addressInformation = modelMapper.map(addressInformationRequest,AddressInformation.class);
        Long addressInformationId = addressInformationRepository.save(addressInformation);
        Long contactInformationId = contactInformationRepository.save(contactInformation);
        return personalInformationRepository.save(new PersonalInformation(userId,addressInformationId,contactInformationId));
    }
}
