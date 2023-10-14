package az.growlab.restapiexample.mapper;

import az.growlab.restapiexample.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();

        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getBigDecimal("price"));
        LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
        product.setCreatedAt(createdAt);
        LocalDateTime updatedAt = rs.getTimestamp("updated_at")==null?null:
                rs.getTimestamp("updated_at").toLocalDateTime();
        product.setUpdatedAt(updatedAt);

        return product;
    }
}
