package az.growlab.creditorleadjpa.dto;

import az.growlab.creditorleadjpa.entity.ContactInformation;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonalInformationRequest {
    private Long userId;
    private AddressInformationRequest addressInformationRequest;
    private ContactInformationRequest contactInformationRequest;
}
