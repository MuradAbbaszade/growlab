package az.growlab.restapiexample.service;

import az.growlab.restapiexample.domain.Product;
import az.growlab.restapiexample.dto.ProductRequest;
import az.growlab.restapiexample.dto.ProductResponse;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    ProductResponse findById(Long id) throws NotFoundException;

    List<Product> findAll();

    void deleteById(Long id) throws NotFoundException;

    Product addProduct(ProductRequest productRequest);

    Product updateProduct(Long id, ProductRequest productRequest) throws NotFoundException;
}
