package org.example.bank.entity;

public class TransferData {
    private long idFrom;
    private long idTo;
    private double amount;

    public TransferData() {
    }

    public TransferData(long idFrom, long idTo, double amount) {
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.amount = amount;
    }

    public long getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(long idFrom) {
        this.idFrom = idFrom;
    }

    public long getIdTo() {
        return idTo;
    }

    public void setIdTo(long idTo) {
        this.idTo = idTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransferData{" +
                "idFrom=" + idFrom +
                ", idTo=" + idTo +
                ", amount=" + amount +
                '}';
    }
}
