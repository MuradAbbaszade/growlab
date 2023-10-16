package az.growlab.creditor_lead.service;

import az.growlab.creditor_lead.enums.ActionStatus;
import az.growlab.creditor_lead.enums.LeadResponseStatus;
import org.springframework.stereotype.Service;

@Service
public interface LeadService {
    String changeActionStatus(Long id, LeadResponseStatus leadResponseStatus,String rejectReason, ActionStatus actionStatus);
}
