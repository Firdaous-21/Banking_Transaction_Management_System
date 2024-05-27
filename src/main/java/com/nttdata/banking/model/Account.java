package com.nttdata.banking.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "account")
public class Account {
    @Id
    private long accountId;
    private String accountHolderName;


    private String accountType;

    private double balance;
    private double iban;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(long accountId, String accountHolderName, String accountType, double balance, double iban, List<Transaction> transactions) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.iban = iban;
        this.transactions = transactions;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getIban() {
        return iban;
    }

    public void setIban(double iban) {
        this.iban = iban;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
