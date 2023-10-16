package az.growlab.creditor_lead.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private Long id;
    private BigDecimal totalAmount;
    private BigDecimal preAmount;
    private BigDecimal interestRate;
    private Long userId;
    private List<Product> productList;
}
