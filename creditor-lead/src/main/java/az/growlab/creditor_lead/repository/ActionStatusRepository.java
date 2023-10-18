package az.growlab.creditor_lead.repository;

import az.growlab.creditor_lead.enums.ActionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ActionStatusRepository {
    private final NamedParameterJdbcTemplate creditorLeadJdbcTemplate;

    public Long getStatusId(String status) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("status", status);
        Long id = creditorLeadJdbcTemplate.queryForObject(
                "SELECT id FROM action_status WHERE status = :status", namedParameters, Long.class);
        return id;
    }

    public ActionStatus findById(Long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        ActionStatus actionStatus = creditorLeadJdbcTemplate.queryForObject(
                "SELECT status FROM action_status WHERE id = :id", namedParameters, ActionStatus.class);
        return actionStatus;
    }

    public ActionStatus getUserActionStatus(Long userId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("user_id", userId);
        Long actionStatusId = creditorLeadJdbcTemplate.queryForObject(
                "SELECT action_status_id FROM users WHERE id = :user_id", namedParameters, Long.class);
        ActionStatus actionStatus = findById(actionStatusId);
        return actionStatus;
    }


}
