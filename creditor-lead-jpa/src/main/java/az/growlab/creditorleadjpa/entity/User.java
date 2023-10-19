package az.growlab.creditorleadjpa.entity;

import az.growlab.creditorleadjpa.enums.ActionStatus;
import az.growlab.creditorleadjpa.enums.FinalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private PersonalInformation personalInformation;
    @OneToOne
    private PassportInformation passportInformation;
    @Enumerated
    private ActionStatus actionStatus;
    @Enumerated
    private FinalStatus finalStatus;

}