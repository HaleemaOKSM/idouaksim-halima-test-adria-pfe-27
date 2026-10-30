package halima.idouaksim.accountservice.web.rest;

import halima.idouaksim.accountservice.domain.Account;
import halima.idouaksim.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {
    private AccountService accountService;
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllBankAccounts() {
        return accountService.getAllAccounts();
    }
    @GetMapping("/accounts/{id}")
    public Account getBankAccountById(@PathVariable UUID id) {
        return accountService.findAccountById(id);
    }

    @PostMapping("/accounts")
    public Account save(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }
}

