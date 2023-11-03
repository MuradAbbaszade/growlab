package az.growlab.creditorleadjpa.entity;

import az.growlab.creditorleadjpa.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassportInformation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String passportNumber;

}
