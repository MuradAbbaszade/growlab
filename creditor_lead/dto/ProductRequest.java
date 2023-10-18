package az.growlab.creditor_lead.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private BigDecimal price;
}
