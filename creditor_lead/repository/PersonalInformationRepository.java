package az.growlab.creditor_lead.repository;

import az.growlab.creditor_lead.domain.AddressInformation;
import az.growlab.creditor_lead.domain.PersonalInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PersonalInformationRepository {
    private final NamedParameterJdbcTemplate creditorLeadJdbcTemplate;

    public Long save(PersonalInformation personalInformation) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id",0)
                .addValue("address_information_id",personalInformation.getAddressInformationId())
                .addValue("contact_information_id",personalInformation.getContactInformationId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        creditorLeadJdbcTemplate.update("INSERT INTO personal_informations VALUES (:id,:address_information_id, :contact_information_id)",namedParameters,keyHolder);
        return keyHolder.getKey().longValue();
    }
}
