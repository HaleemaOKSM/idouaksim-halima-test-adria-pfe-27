package halima.idouaksim.accountservice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter @NoArgsConstructor @AllArgsConstructor @Builder

public class Account {
    @Id @GeneratedValue
    private UUID id;
    private Long customerReference;
    private String status;
    private String currency;
    private double balance;

}
