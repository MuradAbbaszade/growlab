package az.growlab.creditor_lead.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInformation {
    private Long id;
    private Long addressInformationId;
    private Long contactInformationId;
}
