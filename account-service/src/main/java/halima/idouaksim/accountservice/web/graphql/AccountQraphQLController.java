package halima.idouaksim.accountservice.web.graphql;

import halima.idouaksim.accountservice.domain.Account;
import halima.idouaksim.accountservice.repository.AccountRepository;
import halima.idouaksim.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.graphql.data.method.annotation.QueryMapping;
@Controller
public class AccountQraphQLController {

    private final AccountService accountService;

    public AccountQraphQLController(AccountService accountService) {
        this.accountService = accountService;
    }

    @QueryMapping
    public List<Account> accountsList() {
        return accountService.getAllAccounts();
    }

    @QueryMapping
    public Account accountById(@Argument UUID id) {
        return accountService.findAccountById(id);
    }
}
