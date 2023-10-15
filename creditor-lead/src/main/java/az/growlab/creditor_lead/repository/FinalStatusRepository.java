package az.growlab.creditor_lead.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FinalStatusRepository {
    private final NamedParameterJdbcTemplate creditorLeadJdbcTemplate;

    public Long getStatusId(String status){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("status", status);
        Long id = creditorLeadJdbcTemplate.queryForObject(
                "SELECT id FROM final_status WHERE status = :status", namedParameters,Long.class);
        return id;
    }
}
