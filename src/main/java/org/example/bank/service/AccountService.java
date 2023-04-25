package org.example.bank.service;

import org.example.bank.entity.Account;

import java.util.List;

public interface AccountService {
    public double getBalance(long id);
    public void putMoneу(long id, double money);
    public void takeMoney(long id, double money);
    public List<Account> showAllAccounts();
}
