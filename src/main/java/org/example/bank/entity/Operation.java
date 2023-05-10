package org.example.bank.entity;

import org.example.bank.enums.OperationType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "amount")
    private double amount;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "time")
    private LocalTime time;

    @Column(name = "status")
    private boolean status = false;

    @Column(name = "message")
    private String message;

    @Column(name = "opr_type")
    private String oprType;
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name = "account_id")
//    private Account account;
    @Column(name = "account_id")
    private Long account_id;

    public Operation() {
    }

    public Operation(Long account_id, double amount, String oprType, String message) {
        this.account_id = account_id;
        this.amount = amount;
        this.oprType = oprType;
        this.message = message;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOprType() {
        return oprType;
    }

    public void setOprType(String oprType) {
        this.oprType = oprType;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", time=" + time +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", account_id=" + account_id +
                '}';
    }
}
