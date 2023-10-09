package az.growlab.restapiexample.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Setter
public class ProductRequest {
    @NotBlank(message = "Name can't be blank")
    private String name;
    @Min(value = 10, message = "Price can't be lower than 10")
    @Max(value = 10000, message = "Price can't be higher than 10000")
    private BigDecimal price;
}
