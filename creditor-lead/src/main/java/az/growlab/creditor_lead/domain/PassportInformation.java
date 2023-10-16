package az.growlab.creditor_lead.domain;

import az.growlab.creditor_lead.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassportInformation {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date birthDate;
    private Gender gender;
    private String passportNumber;

}
