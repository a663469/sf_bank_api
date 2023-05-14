package org.example.bank.dao;

import org.example.bank.entity.Account;
import org.example.bank.entity.Operation;
import org.example.bank.entity.operations.TakeMoney;
import org.example.bank.enums.OperationType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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

//    @Override
//    public boolean addReservation(long id, double amount) {
//        Session session = sessionFactory.getCurrentSession();
//        Account account = session.get(Account.class, id);
//        account.addReservation(amount);
//        return true;
//    }

//    @Override
//    public boolean removeReservation(long id, double amount) {
//        Session session = sessionFactory.getCurrentSession();
//        Account account = session.get(Account.class, id);
//        account.removeReservation(amount);
//        return true;
//    }

    @Override
    public synchronized boolean putMoney(long id, double money) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.get(Account.class, id);
        account.setBalance(account.getBalance() + money);
        return true;
    }

    @Override
    public synchronized boolean takeMoney(long id, double amount) {
        boolean retVal = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            Account account = session.get(Account.class, id);
            account.setBalance(account.getBalance() - amount);
            retVal = true;
        } catch (Exception e) {
            System.out.println("Error in BankDAOImpl.takeMoney: " + e);
        }
        return retVal;
    }

    @Override
    public List<Account> showAllAccounts() {
        Session session = sessionFactory.getCurrentSession();
        List<Account> accountList = session.createQuery("from Account", Account.class).getResultList();
        return accountList;
    }

    @Override
    public List<Operation> showAllOperations() {
        Session session = sessionFactory.getCurrentSession();
        List<Operation> operationList = session.createQuery("from Operation", Operation.class).getResultList();
        return operationList;
    }

    @Override
    public List<Operation> getOperationList(long id) {
        Session session = sessionFactory.getCurrentSession();
        List<Operation> operationList = session.createQuery("from Operation where account_id =:id", Operation.class)
                .setParameter("id", id).getResultList();
        return operationList;
    }

    @Override
    public boolean saveOrUpdateOperation(Operation operation) {
        boolean retVal = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(operation);
            retVal = true;
        } catch (Exception e) {
            System.out.println("Error in BankDAOImpl.saveOrUpdateOperation: " + e);
            retVal = false;
        }
        return retVal;
    }

    @Override
    public boolean transferMoney(long idFrom, long idTo, double amount) {
        boolean retVal = false;
        Session session = sessionFactory.getCurrentSession();
        Account accountFrom = session.get(Account.class, idFrom);
        Account accountTo = session.get(Account.class, idTo);
        if(accountFrom.getBalance() - amount > 0) {
            accountFrom.setBalance(accountFrom.getBalance() - amount);
            accountTo.setBalance(accountTo.getBalance() + amount);
            retVal = true;
        } else {
            retVal = false;
        }
        return retVal;
    }
}