package az.growlab.creditor_lead.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactInformation {
    private Long id;
    private Long homeNumber;
    private Long workNumber;
    private String mobile;
    private String email;
}
