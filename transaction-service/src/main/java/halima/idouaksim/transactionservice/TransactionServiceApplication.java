package halima.idouaksim.transactionservice;

import halima.idouaksim.transactionservice.domain.Transaction;
import halima.idouaksim.transactionservice.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class TransactionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TransactionService transactionService) {
        return args -> {

            for (int i = 1; i < 3; i++) {
                for (int j = 1; j < 5; j++) {

                    transactionService.save(
                            Transaction.builder()
                                    .accountId(UUID.fromString("1407a4ec-876c-432b-ac13-10b0777b826f"))
                                    .amount(BigDecimal.valueOf(100 + Math.random() * 800))
                                    .currency("MAD")
                                    .merchantCategory(
                                            Math.random() > 0.5 ? "GROCERY" : "SHOPPING")
                                    .country("Morocco")
                                    .build()
                    );
                }
            }
        };
    }

}
