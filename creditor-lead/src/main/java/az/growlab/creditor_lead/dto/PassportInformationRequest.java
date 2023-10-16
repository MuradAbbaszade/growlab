package az.growlab.creditor_lead.dto;

import az.growlab.creditor_lead.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PassportInformationRequest {
    private String name;
    private String surname;
    private String patronymic;
    private Date birthDate;
    private Gender gender;
    private String passportNumber;
}
