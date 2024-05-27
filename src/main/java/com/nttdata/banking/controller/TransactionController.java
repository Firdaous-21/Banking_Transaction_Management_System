package com.nttdata.banking.controller;

import com.nttdata.banking.model.Transaction;
import com.nttdata.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction makeTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }
    @GetMapping("/{id}")
    public Optional<Transaction> getTransaction(@PathVariable long id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

}
