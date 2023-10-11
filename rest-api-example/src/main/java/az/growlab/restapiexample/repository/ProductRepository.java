package az.growlab.restapiexample.repository;

import az.growlab.restapiexample.domain.Product;
import javassist.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Long, Product> products = new HashMap<>();

    public Product findById(Long id) throws NotFoundException {
        if (!products.containsKey(id)) throw new NotFoundException("Product not found.");
        return products.get(id);
    }

    public Product save(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    public void deleteById(Long id) throws NotFoundException {
        if (!products.containsKey(id)) throw new NotFoundException("Product not found.");
        products.remove(id);
    }

    public List<Product> findAll() {
        return toList(products);
    }

    List<Product> toList(Map<Long, Product> productHashMap) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Long, Product> entry : productHashMap.entrySet()) {
            Long key = entry.getKey();
            Product product = entry.getValue();
            product.setId(key);
            productList.add(product);
        }
        return productList;
    }
}
