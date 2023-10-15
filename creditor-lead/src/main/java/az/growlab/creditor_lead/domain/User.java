package az.growlab.creditor_lead.domain;

import az.growlab.creditor_lead.enums.ActionStatus;
import az.growlab.creditor_lead.enums.FinalStatus;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private Long personalInformationId;
    private Long passportInformationId;
    private Long finalStatusId;
    private Long actionStatusId;

    private List<Loan> loanList;
}
