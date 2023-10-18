package az.growlab.creditor_lead.repository;

import az.growlab.creditor_lead.domain.AddressInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AddressInformationRepository {
    private final NamedParameterJdbcTemplate creditorLeadJdbcTemplate;

    public Long save(AddressInformation addressInformation) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 0)
                .addValue("country", addressInformation.getCountry())
                .addValue("city", addressInformation.getCity())
                .addValue("street", addressInformation.getStreet())
                .addValue("postal_code", addressInformation.getPostalCode());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        creditorLeadJdbcTemplate.update("INSERT INTO address_informations VALUES (:id,:country, :city, :street ,:postal_code)", namedParameters, keyHolder);
        return keyHolder.getKey().longValue();
    }
}
