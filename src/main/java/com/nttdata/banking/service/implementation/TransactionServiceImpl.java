package com.nttdata.banking.service.implementation;

import com.nttdata.banking.model.Account;
import com.nttdata.banking.model.Transaction;
import com.nttdata.banking.model.enumiration.TransactionType;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TransactionServiceImpl {
     List<Transaction> getAllTransactions();
     Optional<Transaction> getTransactionById(long id);
     Transaction saveTransaction(Transaction transaction);
     void deleteTransaction(long id);
     Map<Account, List<Transaction>> getTransactionsByAccount();
     Map<TransactionType, List<Transaction>> getTransactionsByType();
     void linkTransactionsToAccount(long accountId, List<Transaction> transactions);
}
