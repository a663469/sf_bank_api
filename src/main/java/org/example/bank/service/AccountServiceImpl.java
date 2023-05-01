package org.example.bank.service;

import org.example.bank.dao.BankDAO;
import org.example.bank.entity.Account;
import org.example.bank.entity.OperationList;
import org.example.bank.entity.operations.TakeMoney;
import org.example.bank.util.RetValBool;
import org.example.bank.util.RetValDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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
    public boolean putMoney(long id, double amount) {
        bankDAO.putMoney(id, amount);
        return true;
    }

    @Override
    @Transactional
    public boolean takeMoney(TakeMoney takeMoney) {
        bankDAO.takeMoney(takeMoney);
        return true;
    }

    @Override
    public OperationList getOperationList(long id, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return null;
    }

    @Override
    public boolean transferMoney(long idFrom, long idTo, double amount) {
        return false;
    }

    @Override
    @Transactional
    public List<Account> showAllAccounts() {
        return bankDAO.showAllAccounts();
    }
}
