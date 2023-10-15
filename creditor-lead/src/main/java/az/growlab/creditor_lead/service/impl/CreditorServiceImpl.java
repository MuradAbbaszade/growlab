package az.growlab.creditor_lead.service.impl;

import az.growlab.creditor_lead.domain.PassportInformation;
import az.growlab.creditor_lead.domain.User;
import az.growlab.creditor_lead.dto.PassportInformationRequest;
import az.growlab.creditor_lead.enums.ActionStatus;
import az.growlab.creditor_lead.enums.FinalStatus;
import az.growlab.creditor_lead.repository.ActionStatusRepository;
import az.growlab.creditor_lead.repository.FinalStatusRepository;
import az.growlab.creditor_lead.repository.PassportInformationRepository;
import az.growlab.creditor_lead.repository.UserRepository;
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
    @Override
    @Transactional
    public int savePassportInformation(PassportInformationRequest passportInformationRequest) {
        PassportInformation passportInformation = modelMapper.map(passportInformationRequest, PassportInformation.class);
        Long passportInformationId = passportInformationRepository.save(passportInformation);
        Long actionStatusId = actionStatusRepository.getStatusId("WAITING_FOR_IDENTITY_APPROVE");
        Long finalStatusId = finalStatusRepository.getStatusId("IN_PROGRESS");
        return userRepository.save(new User(0L,null,passportInformationId,finalStatusId,actionStatusId,null));
    }
}
