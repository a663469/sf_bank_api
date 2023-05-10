package org.example.bank.service;

import org.example.bank.entity.Account;
import org.example.bank.entity.Operation;
import org.example.bank.entity.operations.TakeMoney;
import org.example.bank.util.RetValBool;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountService {
    public double getBalance(long id);
    public boolean saveOrUpdateOperation(Operation operation);
    public RetValBool putMoney(long id, double amount);
    public RetValBool takeMoney(long id, double amount);
    public List<Operation> getOperationList(long id);
    public boolean transferMoney(long idFrom, long idTo, double amount);
    public List<Account> showAllAccounts();
    public List<Operation> showAllOperations();
}
