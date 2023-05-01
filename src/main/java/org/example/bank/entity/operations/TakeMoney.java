package org.example.bank.entity.operations;

import javax.persistence.*;

public class TakeMoney {

    long idAccount;
    double amount;

    public TakeMoney() {
    }

    public TakeMoney(long idAccount, double amount) {
        this.idAccount = idAccount;
        this.amount = amount;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TakeMoney{" +
                "idAccount=" + idAccount +
                ", amount=" + amount +
                '}';
    }
}
