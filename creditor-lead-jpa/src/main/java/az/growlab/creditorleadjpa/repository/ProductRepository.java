package az.growlab.creditorleadjpa.repository;

import az.growlab.creditorleadjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
