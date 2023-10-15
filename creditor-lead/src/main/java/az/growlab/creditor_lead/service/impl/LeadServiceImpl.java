package az.growlab.creditor_lead.service.impl;

import az.growlab.creditor_lead.domain.PassportInformation;
import az.growlab.creditor_lead.domain.User;
import az.growlab.creditor_lead.dto.PassportInformationRequest;
import az.growlab.creditor_lead.enums.ActionStatus;
import az.growlab.creditor_lead.repository.ActionStatusRepository;
import az.growlab.creditor_lead.repository.UserRepository;
import az.growlab.creditor_lead.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LeadServiceImpl implements LeadService {

    private final ActionStatusRepository actionStatusRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public int changeActionStatusById(Long id, ActionStatus actionStatus) {
        Long actionStatusId = actionStatusRepository.getStatusId(actionStatus.toString());
        return userRepository.changeUserActionStatus(id,actionStatusId);
    }
}
