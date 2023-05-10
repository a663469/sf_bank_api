package org.example.bank.controller;

import org.example.bank.entity.Account;
import org.example.bank.entity.Operation;
import org.example.bank.entity.operations.PutMoney;
import org.example.bank.entity.operations.TakeMoney;
import org.example.bank.service.AccountService;
import org.example.bank.util.RetValBool;
import org.example.bank.util.RetValDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public List<Account> showAllAccounts() {
        return accountService.showAllAccounts();
    }

    @GetMapping("/operation")
    public List<Operation> showAllOperations() {
        return accountService.showAllOperations();
    }

    @GetMapping("/account/{id}")
    public RetValDouble getBalance(@PathVariable long id) {
        RetValDouble retVal = new RetValDouble();
        try {
            retVal.setValue(accountService.getBalance(id));
            retVal.setMessage("The operation was completed successfully");
        } catch (Exception e) {
            retVal.setValue(-1);
            retVal.setMessage("Error: " + e.toString());
        }
        return retVal;
    }

    @PostMapping("/account/take")
    public RetValBool takeMoney(@RequestBody TakeMoney takeMoney) {
        RetValBool retVal = new RetValBool();
        try {
            retVal = accountService.takeMoney(takeMoney.getIdAccount(), takeMoney.getAmount());
        } catch (Exception e) {
            retVal.setValue(false);
            retVal.setMessage("The error was caught by the REST controller: " + e.toString());
        }
        return retVal;
    }

    @PostMapping("/account/put")
    public RetValBool putMoney(@RequestBody PutMoney putMoney) {
        RetValBool retVal = new RetValBool();
        try {
            retVal = accountService.putMoney(putMoney.getIdAccount(), putMoney.getAmount());
            retVal.setMessage("The operation was completed successfully");
        } catch (Exception e) {
            retVal.setValue(false);
            retVal.setMessage("The error was caught by the REST controller: " + e.toString());
        }
        return retVal;
    }

    @GetMapping("/account/operations/{id}")
    public List<Operation> getOperationList(@PathVariable long id) {
        System.out.println("id = " + id);
        return accountService.getOperationList(id);
    }

    public boolean transferMoney(@PathVariable long idFrom, long idTo, double amount) {
        return false;
    }
}
