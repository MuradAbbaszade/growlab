package az.growlab.creditorleadjpa.entity;

import az.growlab.creditorleadjpa.enums.ActionStatus;
import az.growlab.creditorleadjpa.enums.FinalStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private PersonalInformation personalInformation;
    @OneToOne
    private PassportInformation passportInformation;
    @Enumerated(EnumType.STRING)
    private ActionStatus actionStatus;
    @Enumerated(EnumType.STRING)
    private FinalStatus finalStatus;
    @OneToMany(mappedBy = "user")
    private List<Loan> loanList;

}
