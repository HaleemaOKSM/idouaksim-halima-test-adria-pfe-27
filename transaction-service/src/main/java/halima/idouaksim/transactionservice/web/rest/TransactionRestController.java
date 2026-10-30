package halima.idouaksim.transactionservice.web.rest;

import halima.idouaksim.transactionservice.domain.Transaction;
import halima.idouaksim.transactionservice.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TransactionRestController {
    private TransactionService transactionService;

    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("/transactions")
    public List<Transaction> getAllBankAccounts() {
        return transactionService.getAllTransactions();
    }
    @GetMapping("/transactions/{id}")
    public Transaction getBankAccountById(@PathVariable UUID id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/transactions")
    public Transaction save(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }
}
