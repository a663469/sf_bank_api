package org.example.bank.dao;

import org.example.bank.entity.Account;

import java.util.List;

public interface BankDAO {

    public double getBalance(long id);
    public void putMoneу(long id, double money);
    public void takeMoney(long id, double money);
    public List<Account> showAllAccounts();
}
