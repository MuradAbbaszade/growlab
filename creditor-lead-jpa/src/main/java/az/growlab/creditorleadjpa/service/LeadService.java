package az.growlab.creditorleadjpa.service;
import az.growlab.creditorleadjpa.dto.LeadRequest;
import az.growlab.creditorleadjpa.enums.ActionStatus;
import org.springframework.stereotype.Service;

@Service
public interface LeadService {
    void changeIdentityStatus(LeadRequest leadRequest, ActionStatus actionStatus);
}
