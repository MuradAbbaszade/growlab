package az.growlab.creditorleadjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal totalAmount;
    private BigDecimal preAmount;
    private BigDecimal interestRate;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @OneToMany(mappedBy = "loan")
    List<Product> productList;

}
