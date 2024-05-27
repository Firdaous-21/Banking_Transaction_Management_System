package com.nttdata.banking.service;

import com.nttdata.banking.model.Account;
import com.nttdata.banking.model.Transaction;
import com.nttdata.banking.model.enumiration.TransactionType;
import com.nttdata.banking.repository.AccountRepository;
import com.nttdata.banking.repository.TransactionRepository;
import com.nttdata.banking.service.implementation.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService implements TransactionServiceImpl {


    private final AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    /**
     * Dependency injection
     * @param transactionRepository: TransactionRepository
     */
    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    /**
     * Display the list of all existing transactions
     * @return List<Transaction>
     */
    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    /**
     * Get the transaction using the id account provided as a parameter
     * @param id: long
     * @return Optional<Transaction>
     */
    @Override
    public Optional<Transaction> getTransactionById(long id) {
        return transactionRepository.findById(id);
    }

    /**
     * Create a transaction
     * @param transaction: Transaction
     * @return Transaction
     */
    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    /**
     * Delete the transaction using the id provided as a parameter
     * @param id: long
     */
    @Override
    public void deleteTransaction(long id) {
        transactionRepository.deleteById(id);
    }

    /**
     * Display a Map with Account as key and List of Transaction as value
     * @return Map<Account, List<Transaction>>
     */
    public Map<Account, List<Transaction>> getTransactionsByAccount() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().collect(Collectors.groupingBy(Transaction::getAccount));
    }

    /**
     * Display a Map with type as key and List of Transaction as value
     * @return Map<Account, List<Transaction>>
     */
    public Map<TransactionType, List<Transaction>> getTransactionsByType() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().collect(Collectors.groupingBy(Transaction::getTransactionType));
    }

    /**
     * link a Transactions to an Account using a JSON file
     * @param accountId: long
     * @param transactions: List<Transaction>
     */
    public void linkTransactionsToAccount(long accountId, List<Transaction> transactions){
        Account account = accountRepository.findById(accountId)
                .orElseThrow(()-> new RuntimeException("Account Not Found"));

        transactions.forEach(transaction -> transaction.setAccount(account));
        transactionRepository.saveAll(transactions);

    }
}
