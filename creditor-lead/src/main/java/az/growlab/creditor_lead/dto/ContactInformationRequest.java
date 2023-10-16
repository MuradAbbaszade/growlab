package az.growlab.creditor_lead.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactInformationRequest {
    private Integer homeNumber;
    private Integer workNumber;
    private String mobile;
    private String email;
}
