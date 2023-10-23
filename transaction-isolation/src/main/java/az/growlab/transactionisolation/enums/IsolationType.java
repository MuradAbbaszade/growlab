package az.growlab.transactionisolation.enums;

import lombok.Getter;

@Getter
public enum IsolationType {
    SERIALIZABLE,REPEATABLE_READ,READ_COMMITTED,READ_UNCOMMITTED
}
