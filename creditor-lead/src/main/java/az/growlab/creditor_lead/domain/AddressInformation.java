package az.growlab.creditor_lead.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressInformation {
    private Long id;
    private String country;
    private String city;
    private String street;
    private String postalCode;
}
