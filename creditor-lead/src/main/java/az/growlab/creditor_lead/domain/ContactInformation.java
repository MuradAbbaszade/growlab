package az.growlab.creditor_lead.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInformation {
    private Long id;
    private Long homeNumber;
    private Long workNumber;
    private String mobile;
    private String email;
}
