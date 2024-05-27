package com.nttdata.banking.service;

import com.nttdata.banking.model.Account;
import com.nttdata.banking.repository.AccountRepository;
import com.nttdata.banking.service.implementation.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceImpl {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(long id) {
        return accountRepository.findById(id);
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(long id) {
        accountRepository.deleteById(id);
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }
}
