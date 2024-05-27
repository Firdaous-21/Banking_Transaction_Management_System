package com.nttdata.banking.controller;

import com.nttdata.banking.model.Account;
import com.nttdata.banking.service.AccountService;
import com.nttdata.banking.service.implementation.BankingLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BankingLogger {

    private AccountService accountService;
    @Autowired
    public void setAccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     *
     * Create a bank account
     * @param account : Account
     * @return Account
     */
    @PostMapping
    public Account createAccount( @RequestBody Account account) {
        LOGGER.info("account supposed to be created");
        return accountService.saveAccount(account);
    }

    /**
     *
     * Display the list of all existing accounts
     * @return List<Account>
     */
    @GetMapping
    public List<Account> getAllAccounts() {
        LOGGER.info("Accounts List to be displayed");
        return accountService.getAllAccounts();
    }

    /**
     * Get the account using the id account provided as a parameter
     * @param id: long
     * @return Optional<Account>
     */
    @GetMapping("/{id}")
    public Optional<Account> getAccountService(@PathVariable long id) {
        LOGGER.info("Account to be displayed");
       return accountService.getAccountById(id);
    }

    /**
     * Update the account
     * @param account: Account
     * @return Account
     */
    @PutMapping
    public Account updateAccount(@RequestBody Account account) {
        LOGGER.info("Account to be updated");
        return accountService.updateAccount(account);
    }

    /**
     * Delete the account using the id provided as a parameter
     * @param id: long
     */
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable long id) {
        LOGGER.info("Account to be deleted");
        accountService.deleteAccount(id);
    }
}
