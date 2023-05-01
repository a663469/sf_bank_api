package org.example.bank.entity.operations;

public class PutMoney {
    long idAccount;
    double amount;

    public PutMoney() {
    }

    public PutMoney(long idAccount, double amount) {
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
        return "PutMoney{" +
                "idAccount=" + idAccount +
                ", amount=" + amount +
                '}';
    }
}
