package halima.idouaksim.accountservice;

import halima.idouaksim.accountservice.domain.Account;
import halima.idouaksim.accountservice.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(AccountService accountService) {
        return args -> {
            for (int i = 1; i < 3; i++) {
                for (int j = 1; j < 5; j++) {
                   accountService.saveAccount(Account.builder()
                           .status(Math.random()>0.5? "ACTIVE" : "BLOCKED")
                            .balance(1000 + Math.random()*60000)
                            .customerReference(Long.valueOf(i))
                           .currency(Math.random()>0.5? "MAD" : "EUR")
                            .build());
                }

            }
        };
    }
}
