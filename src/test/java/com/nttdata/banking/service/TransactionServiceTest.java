package com.nttdata.banking.service;

import com.nttdata.banking.model.Account;
import com.nttdata.banking.model.Transaction;
import com.nttdata.banking.model.enumiration.TransactionType;
import com.nttdata.banking.repository.AccountRepository;
import com.nttdata.banking.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;
import java.util.stream.Collectors;

import static com.nttdata.banking.model.enumiration.TransactionType.DEPOSIT;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransactionService transactionService;

    private Transaction transaction;

    private Account account;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        account = new Account(1L, "Firdaous", "Savings", 3000.0, 1234567890.0, null);
        transaction = new Transaction(1L, DEPOSIT,null, 100.0, account);

    }
    @Test
    void Should_GetTransactions() {
        //given
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);

        //when
        when(transactionRepository.findAll()).thenReturn(transactionList);

        //then
        assertEquals(transactionList, transactionService.getAllTransactions());
    }

    @Test
    void Should_GetTransaction_When_TransactionExist() {
        //given
        Optional<Transaction> transactionOptional = Optional.of(transaction);

        //when
        when(transactionService.getTransactionById(1L)).thenReturn(transactionOptional);

        //then
        assertNotNull(transactionService.getTransactionById(1L));
    }

    @Test
    void Should_CreateTransaction() {
        //given

        //when
        when(transactionRepository.save(transaction)).thenReturn(transaction);
        //then
        assertNotNull(transactionService.saveTransaction(transaction));
    }

    @Test
    void Should_DeleteTransaction() {
        //given
        transactionService.deleteTransaction(1L);
        //then
        verify(transactionRepository).deleteById(1L);
    }

    @Test
    void should_getTransactionsByAccount(){
        //given
        transactionService.getTransactionsByAccount();
        //then
        verify(transactionRepository).findAll();
    }


    @Test
    void should_getTransactionsByType(){
        //given
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);
        //when
        when(transactionRepository.findAll()).thenReturn(transactionList);
        //then
        assertNotNull(transactionService.getTransactionsByType());
    }

    @Test
    void should_linkTransactionsToAccount(){
        //given
        Optional<Account> accountOptional = Optional.of(account);
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);

        //when
        when(accountRepository.findById(1l)).thenReturn(accountOptional);
        transactionService.linkTransactionsToAccount(account.getAccountId(),transactionList);
        //then
        verify(accountRepository).findById(1l);
    }
}