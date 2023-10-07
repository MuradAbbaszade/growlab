package az.growlab.restapiexample.controller;

import az.growlab.restapiexample.controller.dto.ProductRequestDto;
import az.growlab.restapiexample.controller.dto.ProductResponseDto;
import az.growlab.restapiexample.controller.dto.ProductUpdateRequestDto;
import az.growlab.restapiexample.model.Product;
import io.swagger.models.auth.In;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
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
    public ProductResponseDto getProduct(@PathVariable Long id) throws NotFoundException {
        if (!products.containsKey(id)) throw new NotFoundException("Product not found.");
        Product product = products.get(id);
        return modelMapper.map(product, ProductResponseDto.class);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return toList(products);
    }

    @PostMapping("/add-product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductResponseDto addProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
        Product product = modelMapper.map(productRequestDto, Product.class);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(null);
        product.setId(Product.idCounter++);
        products.put(product.getId(), product);
        log.info("Product added. ID:{}", product.getId());
        return modelMapper.map(product, ProductResponseDto.class);
    }

    @PutMapping("/update-product")
    public ProductResponseDto updateProduct(@Valid @RequestBody ProductUpdateRequestDto productUpdateRequestDto) throws NotFoundException {
        if (!products.containsKey(productUpdateRequestDto.getId())) throw new NotFoundException("Product not found.");
        Product product = update(productUpdateRequestDto);
        log.info("Product updated. ID:{}", product.getId());
        return modelMapper.map(product, ProductResponseDto.class);
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

    Product update(ProductUpdateRequestDto productUpdateRequestDto) {
        Product product = products.get(productUpdateRequestDto.getId());
        product.setName(productUpdateRequestDto.getName());
        product.setPrice(productUpdateRequestDto.getPrice());
        product.setUpdatedAt(LocalDateTime.now());
        return product;
    }
}
