package org.example.bank.service;

import org.example.bank.dao.BankDAO;
import org.example.bank.entity.Account;
import org.example.bank.entity.Operation;
import org.example.bank.entity.operations.TakeMoney;
import org.example.bank.util.RetValBool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
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
    public boolean saveOrUpdateOperation(Operation operation) {
        return bankDAO.saveOrUpdateOperation(operation);
    }


    @Override
    @Transactional
    public RetValBool putMoney(long id, double amount) {
        RetValBool retValBool = new RetValBool(false, "Error");
        if (amount < 0) amount = -amount;
        String message;
        Operation operation = new Operation(id, amount, "putMoney", "putMoney Operation");
        if (bankDAO.saveOrUpdateOperation(operation)) {
            if (bankDAO.putMoney(id, amount)) {
                message = "The operation putMoney was completed successfully";
                operation.setStatus(true);
                operation.setMessage(message);
                retValBool.setValue(true);
                retValBool.setMessage(message);
            } else {
                message = "Error when trying to withdraw money";
                retValBool.setMessage(message);
                operation.setMessage(message);
                retValBool.setValue(false);
            }
        } else {
            message = "Error while trying to register the operation";
            retValBool.setMessage(message);
            operation.setMessage(message);
            retValBool.setValue(false);
        }
        return retValBool;
    }

    @Override
    @Transactional
    public RetValBool takeMoney(long id, double amount) {
        RetValBool retValBool = new RetValBool(false, "Error");
        if(amount < 0) amount = -amount;
        String message;
        Operation operation = new Operation(id, amount, "takeMoney","takeMoney Operation");
        if(bankDAO.saveOrUpdateOperation(operation)) {
            if (bankDAO.getBalance(id) - amount > 0) {
                if (bankDAO.takeMoney(id, amount)) {
                    message = "The operation takeMoney was completed successfully";
                    operation.setStatus(true);
                    operation.setMessage(message);
                    retValBool.setValue(true);
                    retValBool.setMessage(message);
                } else {
                    message = "Error when trying to withdraw money";
                    retValBool.setMessage(message);
                    operation.setMessage(message);
                    retValBool.setValue(false);
                }
            } else {
                message = "Not enough money in the account!";
                retValBool.setMessage(message);
                operation.setMessage(message);
                retValBool.setValue(false);
            }
        } else {
            message = "Error while trying to register the operation";
            retValBool.setMessage(message);
            operation.setMessage(message);
            retValBool.setValue(false);
        }
        return retValBool;
    }

    @Override
    @Transactional
    public List<Operation> getOperationList(long id) {
        return bankDAO.getOperationList(id);
    }

    @Override
    @Transactional
    public boolean transferMoney(long idFrom, long idTo, double amount) {
        return false;
    }

    @Override
    @Transactional
    public List<Account> showAllAccounts() {
        return bankDAO.showAllAccounts();
    }

    @Override
    @Transactional
    public List<Operation> showAllOperations() {
        return bankDAO.showAllOperations();
    }
}
