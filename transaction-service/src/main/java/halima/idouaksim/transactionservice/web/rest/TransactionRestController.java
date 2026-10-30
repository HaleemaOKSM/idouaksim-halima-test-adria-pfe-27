package halima.idouaksim.transactionservice.web.rest;

import halima.idouaksim.transactionservice.domain.Transaction;
import halima.idouaksim.transactionservice.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TransactionRestController {
    private TransactionService transactionService;

    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    @GetMapping("/transactions/{id}")
    public Transaction getTransactionById(@PathVariable UUID id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/transactions")
    public Transaction save(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }
}
