package halima.idouaksim.transactionservice.web.graphql;

import halima.idouaksim.transactionservice.domain.Transaction;
import halima.idouaksim.transactionservice.service.TransactionService;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class TransactionQraphQLController {
    private final TransactionService transactionService;

    public TransactionQraphQLController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @QueryMapping
    public List<Transaction> transactionsList() {
        return transactionService.getAllTransactions();
    }

    @QueryMapping
    public Transaction transactionById(@Argument UUID id) {
        return transactionService.getTransactionById(id);
    }

    @MutationMapping
    public Transaction createTransaction(
            @Argument UUID accountId,
            @Argument BigDecimal amount,
            @Argument String currency,
            @Argument String merchantCategory,
            @Argument String country) {

        Transaction transaction = Transaction.builder()
                .accountId(accountId)
                .amount(amount)
                .currency(currency)
                .merchantCategory(merchantCategory)
                .country(country)
                .build();

        return transactionService.save(transaction);
    }
}
