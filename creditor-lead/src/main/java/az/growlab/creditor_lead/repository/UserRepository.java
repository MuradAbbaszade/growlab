package az.growlab.creditor_lead.repository;

import az.growlab.creditor_lead.domain.PassportInformation;
import az.growlab.creditor_lead.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final NamedParameterJdbcTemplate creditorLeadJdbcTemplate;

    public int save(User user) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 0)
                .addValue("passport_information_id", user.getPassportInformationId())
                .addValue("personal_information_id", user.getPersonalInformationId())
                .addValue("action_status_id", user.getActionStatusId())
                .addValue("final_status_id", user.getFinalStatusId());
        return creditorLeadJdbcTemplate.
                update("INSERT INTO users VALUES (:id,:passport_information_id, :personal_information_id, :action_status_id ,:final_status_id)", namedParameters);
    }

    public int changeUserActionStatus(Long userId, Long actionStatusId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", userId)
                .addValue("action_status_id", actionStatusId);
        return creditorLeadJdbcTemplate.update("UPDATE users set action_status_id=:action_status_id where id=:id", namedParameters);
    }

}
