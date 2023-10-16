package az.growlab.creditor_lead.service.impl;

import az.growlab.creditor_lead.domain.PassportInformation;
import az.growlab.creditor_lead.domain.User;
import az.growlab.creditor_lead.dto.PassportInformationRequest;
import az.growlab.creditor_lead.enums.ActionStatus;
import az.growlab.creditor_lead.enums.LeadResponseStatus;
import az.growlab.creditor_lead.repository.ActionStatusRepository;
import az.growlab.creditor_lead.repository.UserRepository;
import az.growlab.creditor_lead.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeadServiceImpl implements LeadService {

    private final ActionStatusRepository actionStatusRepository;
    private final UserRepository userRepository;

    @Override
    public String changeActionStatus(Long id, LeadResponseStatus leadResponseStatus, String rejectReason, ActionStatus actionStatus) {
        if(leadResponseStatus.equals(LeadResponseStatus.APPROVE)){
            Long actionStatusId = actionStatusRepository.getStatusId(actionStatus.toString());
            userRepository.changeUserActionStatus(id,actionStatusId);
            return actionStatus+" "+id;
        }
        if(rejectReason==null) throw new UnsupportedOperationException("Reject reason is required for NEED_TO_IMPROVE and DECLINE status.");
        return id+" Rejected.Reason: "+rejectReason;
    }
}
