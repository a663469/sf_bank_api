package org.example.bank.controller;

import org.example.bank.entity.Account;
import org.example.bank.entity.OperationList;
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

    @GetMapping("/")
    public List<Account> showAllAccounts() {
        return accountService.showAllAccounts();
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
        System.out.println("takeMoney");
        RetValBool retVal = new RetValBool();
        try {
            retVal.setValue(accountService.takeMoney(takeMoney));
            retVal.setMessage("The operation was completed successfully");
        } catch (Exception e) {
            retVal.setValue(false);
            retVal.setMessage("Error: " + e.toString());
        }
        return retVal;
    }

    @PostMapping("/account/put")
    public RetValBool putMoney(@RequestBody PutMoney putMoney) {
        System.out.println("putMoney");
        RetValBool retVal = new RetValBool();
        try {
            retVal.setValue(accountService.putMoney(putMoney.getIdAccount(), putMoney.getAmount()));
            retVal.setMessage("The operation was completed successfully");
        } catch (Exception e) {
            retVal.setValue(false);
            retVal.setMessage("Error: " + e.toString());
        }
        return retVal;
    }

    public OperationList getOperationList(@PathVariable long id, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return new OperationList();
    }

    public boolean transferMoney(@PathVariable long idFrom, long idTo, double summa) {
        return false;
    }
}
