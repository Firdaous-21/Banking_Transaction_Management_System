package com.nttdata.banking.controller;

import com.nttdata.banking.model.Account;
import com.nttdata.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

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
    public Account createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    /**
     *
     * Display the list of all existing accounts
     * @return List<Account>
     */
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccountService(@PathVariable long id) {
       return accountService.getAccountById(id);
    }

    @PutMapping
    public Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping
    public void deleteAccount(@PathVariable long id) {
        accountService.deleteAccount(id);
    }
}
