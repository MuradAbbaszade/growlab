package az.growlab.creditorleadjpa.entity;

import az.growlab.creditorleadjpa.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class PassportInformation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date birthDate;
    @Enumerated
    private Gender gender;
    private String passportNumber;

}
