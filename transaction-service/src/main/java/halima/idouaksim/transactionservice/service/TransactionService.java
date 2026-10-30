package halima.idouaksim.transactionservice.service;

import halima.idouaksim.transactionservice.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


}
