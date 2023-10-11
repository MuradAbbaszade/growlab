package az.growlab.restapiexample.service.impl;

import az.growlab.restapiexample.domain.Product;
import az.growlab.restapiexample.dto.ProductRequest;
import az.growlab.restapiexample.dto.ProductResponse;
import az.growlab.restapiexample.repository.ProductRepository;
import az.growlab.restapiexample.service.ProductService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponse findById(Long id) throws NotFoundException {
        Product product = productRepository.findById(id);
        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        productRepository.deleteById(id);
    }

    @Override
    public Product addProduct(ProductRequest productRequest) {
        Product product = modelMapper.map(productRequest, Product.class);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(null);
        product.setId(Product.idCounter++);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long id, ProductRequest productRequest) throws NotFoundException {
        Product product = productRepository.findById(id);
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setUpdatedAt(LocalDateTime.now());
        return product;
    }

}
