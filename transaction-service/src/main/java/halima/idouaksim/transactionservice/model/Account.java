package halima.idouaksim.transactionservice.model;


import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Account {
    private UUID id;
    private Long customerReference;
    private String status;
    private String currency;
    private double balance;

}
