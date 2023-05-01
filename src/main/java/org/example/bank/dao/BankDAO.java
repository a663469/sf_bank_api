package org.example.bank.dao;

import org.example.bank.entity.Account;
import org.example.bank.entity.operations.TakeMoney;

import java.util.List;

public interface BankDAO {

    public double getBalance(long id);
    public double putMoney(long id, double money);
    public double takeMoney(TakeMoney takeMoney);
    public List<Account> showAllAccounts();
}
