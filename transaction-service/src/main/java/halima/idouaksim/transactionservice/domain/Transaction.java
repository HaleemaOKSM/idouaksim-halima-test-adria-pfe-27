package halima.idouaksim.transactionservice.domain;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Setter
@Getter @NoArgsConstructor @AllArgsConstructor @Builder

public class Transaction {
    @Id
    private UUID id;

    private UUID accountId;

    private BigDecimal amount;

    private String currency;

    private String merchantCategory;

    private String country;

    private Instant createdAt;

}
