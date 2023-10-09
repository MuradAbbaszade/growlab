package az.growlab.restapiexample.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponse {
    private String name;
    private BigDecimal price;
    private LocalDateTime createdAt;
}
