package halima.idouaksim.transactionservice.service;

import halima.idouaksim.transactionservice.domain.Transaction;
import halima.idouaksim.transactionservice.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public Transaction getTransactionById( UUID id) {
        return transactionRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Bank account not found"));
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
