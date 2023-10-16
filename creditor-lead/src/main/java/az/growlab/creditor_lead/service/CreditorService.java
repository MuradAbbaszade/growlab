package az.growlab.creditor_lead.service;

import az.growlab.creditor_lead.dto.AddressInformationRequest;
import az.growlab.creditor_lead.dto.ContactInformationRequest;
import az.growlab.creditor_lead.dto.PassportInformationRequest;
import az.growlab.creditor_lead.exception.custom.CustomNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface CreditorService {
    int savePassportInformation(PassportInformationRequest passportInformationRequest);
    Long saveContactAndAddressInformation(Long userId,ContactInformationRequest contactInformationRequest,
                                         AddressInformationRequest addressInformationRequest) throws CustomNotFoundException;
}
