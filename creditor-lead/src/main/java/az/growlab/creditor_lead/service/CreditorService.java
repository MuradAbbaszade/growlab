package az.growlab.creditor_lead.service;

import az.growlab.creditor_lead.dto.PassportInformationRequest;
import org.springframework.stereotype.Service;

@Service
public interface CreditorService {
    int savePassportInformation(PassportInformationRequest passportInformationRequest);
}
