package az.growlab.creditorleadjpa.dto;

import az.growlab.creditorleadjpa.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
public class PassportInformationRequest {
    private String name;
    private String surname;
    private String patronymic;
    private Date birthDate;
    private Gender gender;
    private String passportNumber;
}
