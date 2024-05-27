package com.nttdata.banking.service;

import com.nttdata.banking.model.Account;
import com.nttdata.banking.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AccountServiceTest {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService ;

    private Account account;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        account = new Account(1L, "Firdaous", "Savings", 3000.0, 1234567890.0, null);

    }

    @Test
    void Should_GetAccounts() {
        //given
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);

        //when
        when(accountRepository.findAll()).thenReturn(accountList);

        //then
        assertEquals(accountList, accountService.getAllAccounts());

    }

    @Test
    void Should_GetAccount_When_AccountExist() {
        //given
        Optional<Account> accountOptional = Optional.of(account);

        //when
        when(accountService.getAccountById(1)).thenReturn(accountOptional);

        //then
        assertNotNull(accountService.getAccountById(1));
    }

    @Test
    void Should_CreateAccount() {
       //given

       //when
        when(accountRepository.save(account)).thenReturn(account);
        //then
        assertNotNull(accountService.saveAccount(account));
    }

    @Test
    void Should_DeleteAccount() {
        //given
        accountService.deleteAccount(1L);
        //then
        verify(accountRepository).deleteById(1L);
    }

    @Test
    void Should_UpdateAccount() {
        //given
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        //when
        when(accountRepository.save(account)).thenReturn(account);
        //then
        assertEquals(account, accountService.updateAccount(account));
    }
}