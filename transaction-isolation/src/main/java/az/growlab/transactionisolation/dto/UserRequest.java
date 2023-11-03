package az.growlab.transactionisolation.dto;

import az.growlab.transactionisolation.enums.ActionType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequest {
    private int id;
    private String name;
    private String surname;
}
