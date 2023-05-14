package org.example.bank.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "balance")
    private double balance;

//    @Column(name = "booking")
//    private double booking = 0;

    public Account() {
    }
    public Account(double balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

//    public double getBooking() {
//        return booking;
//    }
//
//    public void addReservation(double amount) {
//        booking = booking + amount;
//    }
//
//    public void removeReservation(double amount) {
//        booking = booking - amount;
//    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
