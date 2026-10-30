package halima.idouaksim.transactionservice.feign;

import halima.idouaksim.transactionservice.model.Account;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "account-service")
public interface AccountRestClient {
    @GetMapping("/accounts/{id}")
    @CircuitBreaker(name="accountService", fallbackMethod = "getDefaultaccount")
    Account getAccountssById(@PathVariable UUID id);

    default Account getDefaultaccount(UUID id, Exception e) {
        return new Account(id,Long.parseLong("0"),"No status","no currency",0.00);    }
}
