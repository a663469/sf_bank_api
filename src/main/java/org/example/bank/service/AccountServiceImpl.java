package org.example.bank.service;

import org.example.bank.dao.BankDAO;
import org.example.bank.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private BankDAO bankDAO;


    @Override
    @Transactional
    public double getBalance(long id) {
        return bankDAO.getBalance(id);
    }

    @Override
    @Transactional
    public void putMoneу(long id, double money) {
        bankDAO.putMoneу(id, money);
    }

    @Override
    @Transactional
    public void takeMoney(long id, double money) {
        bankDAO.takeMoney(id, money);
    }

    @Override
    @Transactional
    public List<Account> showAllAccounts() {
        return bankDAO.showAllAccounts();
    }
}
