package az.growlab.creditor_lead.repository;

import az.growlab.creditor_lead.domain.Loan;
import az.growlab.creditor_lead.domain.PassportInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LoanRepository {
    private final NamedParameterJdbcTemplate creditorLeadJdbcTemplate;
    public Long save(Loan loan) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id",0)
                .addValue("total_amount",loan.getTotalAmount())
                .addValue("pre_amount",loan.getPreAmount())
                .addValue("interest_rate",loan.getInterestRate())
                .addValue("user_id",loan.getUserId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        creditorLeadJdbcTemplate.update("INSERT INTO loans VALUES (:id,:total_amount, :pre_amount, :interest_rate ,:user_id)",namedParameters,keyHolder);
        return keyHolder.getKey().longValue();
    }
}
