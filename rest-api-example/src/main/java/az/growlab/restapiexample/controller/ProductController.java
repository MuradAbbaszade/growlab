package az.growlab.restapiexample.controller;

import az.growlab.restapiexample.dto.ProductRequest;
import az.growlab.restapiexample.dto.ProductResponse;
import az.growlab.restapiexample.domain.Product;
import az.growlab.restapiexample.service.ProductService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id) throws NotFoundException {
        return productService.findById(id);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @PostMapping("/add-product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product addProduct(@Valid @RequestBody ProductRequest productRequest) {
        Product product = productService.addProduct(productRequest);
        log.info("Product added. ID:{}", product.getId());
        return product;
    }

    @PutMapping("/update-product")
    public Product updateProduct(@RequestParam("id") Long id, @Valid @RequestBody ProductRequest productRequest) throws NotFoundException {
        Product product = productService.updateProduct(id, productRequest);
        log.info("Product updated. ID:{}", id);
        return product;
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable Long id) throws NotFoundException {
        productService.deleteById(id);
        log.info("Product deleted. ID:{}", id);
    }

}
