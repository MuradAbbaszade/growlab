package az.growlab.restapiexample.controller;

import az.growlab.restapiexample.dto.ProductRequest;
import az.growlab.restapiexample.dto.ProductResponse;
import az.growlab.restapiexample.domain.Product;
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

    private final ModelMapper modelMapper;
    Map<Long, Product> products = new HashMap<>();

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id) throws NotFoundException {
        if (!products.containsKey(id)) throw new NotFoundException("Product not found.");
        Product product = products.get(id);
        return modelMapper.map(product, ProductResponse.class);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return toList(products);
    }

    @PostMapping("/add-product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductResponse addProduct(@Valid @RequestBody ProductRequest productRequestDto) {
        Product product = modelMapper.map(productRequestDto, Product.class);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(null);
        product.setId(Product.idCounter++);
        products.put(product.getId(), product);
        log.info("Product added. ID:{}", product.getId());
        return modelMapper.map(product, ProductResponse.class);
    }

    @PutMapping("/update-product")
    public ProductResponse updateProduct(@RequestParam("id") Long id , @Valid @RequestBody ProductRequest productRequest) throws NotFoundException {
        if (!products.containsKey(id)) throw new NotFoundException("Product not found.");
        Product product = update(id,productRequest);
        log.info("Product updated. ID:{}", product.getId());
        return modelMapper.map(product, ProductResponse.class);
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable Long id) throws NotFoundException {
        if (!products.containsKey(id)) throw new NotFoundException("Product not found.");
        products.remove(id);
        log.info("Product deleted. ID:{}", id);
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

    Product update(Long id,ProductRequest productRequest) {
        Product product = products.get(id);
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setUpdatedAt(LocalDateTime.now());
        return product;
    }
}
