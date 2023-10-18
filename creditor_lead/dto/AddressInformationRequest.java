package az.growlab.creditor_lead.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressInformationRequest {
    private String country;
    private String city;
    private String street;
    private String postalCode;
}
