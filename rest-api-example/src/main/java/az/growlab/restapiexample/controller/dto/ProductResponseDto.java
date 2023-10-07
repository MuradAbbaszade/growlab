package az.growlab.restapiexample.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponseDto {
    private String name;
    private BigDecimal price;
    private LocalDateTime createdAt;
}
