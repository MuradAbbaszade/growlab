package az.growlab.creditor_lead.repository;

import az.growlab.creditor_lead.domain.ContactInformation;
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
public class ContactInformationRepository {
    private final NamedParameterJdbcTemplate creditorLeadJdbcTemplate;

    public Long save(ContactInformation contactInformation) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id",0)
                .addValue("home_number",contactInformation.getHomeNumber())
                .addValue("work_number",contactInformation.getWorkNumber())
                .addValue("mobile",contactInformation.getMobile())
                .addValue("email",contactInformation.getEmail());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        creditorLeadJdbcTemplate.update("INSERT INTO contact_informations VALUES (:id,:home_number, :work_number, :mobile ,:email)",namedParameters,keyHolder);
        return keyHolder.getKey().longValue();
    }
}
