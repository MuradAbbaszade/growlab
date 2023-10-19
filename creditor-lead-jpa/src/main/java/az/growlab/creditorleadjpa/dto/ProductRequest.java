package az.growlab.creditorleadjpa.dto;

import az.growlab.creditorleadjpa.entity.Loan;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private BigDecimal price;
}
