package az.growlab.creditor_lead.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PersonalInformationRequest {
    private ContactInformationRequest contactInformationRequest;
    private AddressInformationRequest addressInformationRequest;
}
