package halima.idouaksim.transactionservice.web.mcp;

import halima.idouaksim.transactionservice.domain.Transaction;
import halima.idouaksim.transactionservice.service.TransactionService;

import org.springframework.stereotype.Component;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;

import java.util.List;
import java.util.UUID;

@Component
public class TransactionMcpTools {

    private final TransactionService transactionService;

    public TransactionMcpTools(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @McpTool(description = "Get all bank transactions")
    public List<Transaction> getTransactions() {
        return transactionService.getAllTransactions();
    }

    @McpTool(description = "Get a transaction by its ID")
    public Transaction getTransaction(
            @McpToolParam(description = "Transaction UUID") String id) {
        return transactionService.getTransactionById(UUID.fromString(id));
    }

}