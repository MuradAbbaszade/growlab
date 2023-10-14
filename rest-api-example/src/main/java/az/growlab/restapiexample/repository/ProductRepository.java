package az.growlab.restapiexample.repository;

import az.growlab.restapiexample.config.JdbcTemplateConfig;
import az.growlab.restapiexample.domain.Product;
import az.growlab.restapiexample.mapper.ProductRowMapper;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final NamedParameterJdbcTemplate productJdbcTemplate;

    public Optional<Product> findById(Long id) throws NotFoundException {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        Product product = productJdbcTemplate.queryForObject(
                "SELECT * FROM product WHERE id = :id", namedParameters, new ProductRowMapper());
        return Optional.ofNullable(product);
    }

    public int save(Product product) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", product.getId())
                .addValue("name",product.getName())
                .addValue("price",product.getPrice())
                .addValue("created_at",product.getCreatedAt())
                .addValue("updated_at",product.getUpdatedAt());
        return productJdbcTemplate.update("INSERT INTO product VALUES (:id, :name, :price, :created_at ,:updated_at)",namedParameters);
    }

    public int update(Product product) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", product.getId())
                .addValue("name",product.getName())
                .addValue("price",product.getPrice())
                .addValue("created_at",product.getCreatedAt())
                .addValue("updated_at",product.getUpdatedAt());
        return productJdbcTemplate.update("UPDATE product set name=:name, price=:price, created_at=:created_at ,updated_at=:updated_at WHERE id=:id",namedParameters);
    }

    public void deleteById(Long id) throws NotFoundException {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        productJdbcTemplate.update("DELETE FROM product where id=:id",namedParameters);
    }

    public List<Product> findAll() {
        return productJdbcTemplate.query("SELECT * FROM product", new ProductRowMapper());
    }

}
