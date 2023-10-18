package az.growlab.creditor_lead.repository;

import az.growlab.creditor_lead.domain.Loan;
import az.growlab.creditor_lead.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final NamedParameterJdbcTemplate creditorLeadJdbcTemplate;
    public Long save(Product product) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id",0)
                .addValue("name",product.getName())
                .addValue("price",product.getPrice())
                .addValue("loan_id",product.getLoanId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        creditorLeadJdbcTemplate.update("INSERT INTO products VALUES (:id,:name, :price, :loan_id)",namedParameters,keyHolder);
        return keyHolder.getKey().longValue();
    }
}
