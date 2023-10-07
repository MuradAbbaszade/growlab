package az.growlab.restapiexample.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductUpdateRequestDto {
    private Long id;
    @NotBlank(message = "Name can't be blank")
    private String name;
    @Min(value = 10, message = "Price can't be lower than 10")
    @Max(value = 10000, message = "Price can't be higher than 10000")
    private BigDecimal price;
}
