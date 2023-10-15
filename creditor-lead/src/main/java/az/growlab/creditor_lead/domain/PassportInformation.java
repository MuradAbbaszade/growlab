package az.growlab.creditor_lead.domain;

import az.growlab.creditor_lead.enums.Gender;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PassportInformation {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date birth_date;
    private Gender gender;
    private Long passport_number;

}
