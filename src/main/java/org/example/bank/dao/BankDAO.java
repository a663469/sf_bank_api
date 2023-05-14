package org.example.bank.dao;

import org.example.bank.entity.Account;
import org.example.bank.entity.Operation;
import org.example.bank.entity.operations.TakeMoney;

import java.util.List;

public interface BankDAO {

    public double getBalance(long id);
//    public boolean addReservation(long id, double amount);
//    public boolean removeReservation(long id, double amount);
    public boolean putMoney(long id, double money);
    public boolean takeMoney(long id, double amount);
    public List<Account> showAllAccounts();
    public List<Operation> showAllOperations();
    public List<Operation> getOperationList(long id);
    public boolean saveOrUpdateOperation(Operation operation);
    public boolean transferMoney(long idFrom, long idTo, double amount);
}
