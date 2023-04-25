package org.example.bank.dao;

import org.example.bank.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankDAOImpl implements BankDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public double getBalance(long id) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.get(Account.class, id);
        return account.getBalance();
    }

    @Override
    public void putMoneу(long id, double money) {

    }

    @Override
    public void takeMoney(long id, double money) {

    }

    @Override
    public List<Account> showAllAccounts() {
        Session session = sessionFactory.getCurrentSession();
        List<Account> accountList = session.createQuery("from Account", Account.class).getResultList();
        return accountList;
    }
}
