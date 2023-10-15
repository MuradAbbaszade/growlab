package az.growlab.creditor_lead.service;

import az.growlab.creditor_lead.enums.ActionStatus;
import org.springframework.stereotype.Service;

@Service
public interface LeadService {
    int changeActionStatusById(Long id, ActionStatus actionStatus);
}
