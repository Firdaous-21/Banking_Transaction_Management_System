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

    private AccountRepository accountRepository;

    /**
     * Dependency injection
     * @param accountRepository : AccountRepository
     */
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Display the list of all existing accounts
     * @return List<Account>
     */
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Get the account using the id account provided as a parameter
     * @param id: long
     * @return Optional<Account>
     */
    @Override
    public Optional<Account> getAccountById(long id) {
        return accountRepository.findById(id);
    }

    /**
     * Create a bank account
     * @param account: Account
     * @return Account
     */
    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);

    }

    /**
     * Delete the account using the id provided as a parameter
     * @param id: long
     */
    @Override
    public void deleteAccount(long id) {
        accountRepository.deleteById(id);
    }

    /**
     * Update the account
     * @param account: Account
     * @return Account
     */
    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }
}
