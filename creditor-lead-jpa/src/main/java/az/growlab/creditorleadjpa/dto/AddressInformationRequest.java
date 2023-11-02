package az.growlab.creditorleadjpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddressInformationRequest {
    private String country;
    private String city;
    private String postalCode;
}
