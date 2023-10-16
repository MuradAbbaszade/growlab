package az.growlab.creditor_lead.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressInformation {
    private Long id;
    private String country;
    private String city;
    private String street;
    private String postalCode;
}
