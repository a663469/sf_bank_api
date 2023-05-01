package org.example.bank.service;

import org.example.bank.entity.Account;
import org.example.bank.entity.OperationList;
import org.example.bank.entity.operations.TakeMoney;
import org.example.bank.util.RetValBool;
import org.example.bank.util.RetValDouble;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountService {
    public double getBalance(long id);
    public boolean putMoney(long id, double amount);
    public boolean takeMoney(TakeMoney takeMoney);
    public OperationList getOperationList(long id, LocalDateTime startDateTime, LocalDateTime endDateTime);
    public boolean transferMoney(long idFrom, long idTo, double amount);
    public List<Account> showAllAccounts();
}
