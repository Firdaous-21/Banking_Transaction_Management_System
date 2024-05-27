package com.nttdata.banking.service;

import com.nttdata.banking.model.Transaction;
import com.nttdata.banking.repository.TransactionRepository;
import com.nttdata.banking.service.implementation.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TransactionService implements TransactionServiceImpl {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public Optional<Transaction> getTransactionById(long id) {
        return transactionRepository.findById(id);
    }
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    public void deleteTransaction(long id) {
        transactionRepository.deleteById(id);
    }
}
