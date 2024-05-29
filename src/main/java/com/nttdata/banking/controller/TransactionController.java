package com.nttdata.banking.controller;

import com.nttdata.banking.model.Account;
import com.nttdata.banking.model.Transaction;
import com.nttdata.banking.model.enumiration.TransactionType;
import com.nttdata.banking.service.TransactionService;
import com.nttdata.banking.service.implementation.BankingLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController implements BankingLogger{


    private TransactionService transactionService;
    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     *
     * Create a transaction
     * @param transaction: Transaction
     * @return Transaction
     */
    @PostMapping
    public Transaction makeTransaction(@RequestBody Transaction transaction) {
        LOGGER.info("Transaction created");
        return transactionService.saveTransaction(transaction);
    }

    /**
     * Get the transaction using the id account provided as a parameter
     * @param id: long
     * @return Optional<Transaction>
     */
    @GetMapping("/{id}")
    public Optional<Transaction> getTransaction(@PathVariable long id) {
        LOGGER.info("Transaction details retrieved");
        return transactionService.getTransactionById(id);
    }

    /**
     * Display the list of all existing transactions
     * @return List<Transaction>
     */
    @GetMapping
    public List<Transaction> getAllTransactions() {
        LOGGER.info(" All Transactions details retrieved");
        return transactionService.getAllTransactions();
    }

    /**
     * Delete the transaction using the id provided as a parameter
     * @param id: long
     */
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable long id) {
        LOGGER.info("Transaction deleted");
        transactionService.deleteTransaction(id);
    }

    /**
     * Display a Map with Account as key and List of Transaction as value
     * @return Map<Account, List<Transaction>>
     */
    @GetMapping("/account")
    public Map<Account, List<Transaction>> getAllTransactionsByAccount() {
        LOGGER.info("Transactions retrieved by account");
        return transactionService.getTransactionsByAccount();
    }

    /**
     * Display a Map with type as key and List of Transaction as value
     * @return Map<TransactionType, List<Transaction>>
     */
    @GetMapping("/type")
    public Map<TransactionType, List<Transaction>> getTransactionsByType() {
        LOGGER.info("Transactions retrieved by type");
        return transactionService.getTransactionsByType();
    }

    /**
     * link a Transactions to an Account using a JSON file
     * @param accountId: long
     * @param transactions: List<Transaction>
     */
    @PostMapping("/Link/{accountId}")
    public void linkTransactionToAccount(@PathVariable long accountId, @RequestBody List<Transaction> transactions) {
        transactionService.linkTransactionsToAccount(accountId, transactions);
    }
}
