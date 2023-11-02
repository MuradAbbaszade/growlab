package az.growlab.creditorleadjpa.dto;

import az.growlab.creditorleadjpa.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Getter
@NoArgsConstructor
public class LoanRequest {
    private BigDecimal preAmount;
    private BigDecimal interestRate;
    private Long userId;
    List<ProductRequest> productRequestList;
}
