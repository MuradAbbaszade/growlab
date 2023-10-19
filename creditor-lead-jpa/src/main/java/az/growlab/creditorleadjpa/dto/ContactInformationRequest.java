package az.growlab.creditorleadjpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ContactInformationRequest {
    private Long workNumber;
    private Long homeNumber;
    private String mobile;
    private String email;
}
