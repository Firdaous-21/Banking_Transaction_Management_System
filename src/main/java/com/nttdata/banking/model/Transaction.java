package com.nttdata.banking.model;

import com.nttdata.banking.model.enumiration.TransactionType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    private long transactionId;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private Date transactionDate;
    private double amount;

    public Transaction() {
    }

    public Transaction(long transactionId, TransactionType transactionType, Date transactionDate, double amount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
