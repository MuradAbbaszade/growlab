package az.growlab.creditor_lead.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalInformation {
    private Long id;
    private Long addressInformationId;
    private Long contactInformationId;
}
