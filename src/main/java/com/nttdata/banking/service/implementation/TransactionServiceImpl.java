package com.nttdata.banking.service.implementation;

import com.nttdata.banking.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionServiceImpl {
    public List<Transaction> getAllTransactions();
    public Optional<Transaction> getTransactionById(long id);
    public Transaction saveTransaction(Transaction transaction);
    public void deleteTransaction(long id);
}
