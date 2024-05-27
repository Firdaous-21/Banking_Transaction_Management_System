package com.nttdata.banking.service.implementation;

import com.nttdata.banking.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountServiceImpl {
    public List<Account> getAllAccounts();
    public Optional<Account> getAccountById(long id);
    public Account saveAccount(Account account);
    public void deleteAccount(long id);
    public Account updateAccount(Account account);

}
