package az.growlab.creditor_lead.repository;

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
public class PassportInformationRepository {

    private final NamedParameterJdbcTemplate creditorLeadJdbcTemplate;
    public Long save(PassportInformation passportInformation) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id",0)
                .addValue("name",passportInformation.getName())
                .addValue("surname",passportInformation.getSurname())
                .addValue("patronymic",passportInformation.getPatronymic())
                .addValue("birth_date",passportInformation.getBirth_date())
                .addValue("passport_number",passportInformation.getPassport_number())
                .addValue("gender",passportInformation.getGender().toString());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        creditorLeadJdbcTemplate.update("INSERT INTO passport_informations VALUES (:id,:name, :surname, :patronymic ,:birth_date, :gender, :passport_number)",namedParameters,keyHolder);
        return keyHolder.getKey().longValue();
    }
}
