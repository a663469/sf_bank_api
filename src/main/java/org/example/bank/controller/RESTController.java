package org.example.bank.controller;

import org.example.bank.entity.Account;
import org.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/bank")
public class RESTController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public List<Account> showAllAccounts() {
        System.out.println("showAllAccounts");
        List<Account> accountList = accountService.showAllAccounts();
        return accountList;
    }

    @GetMapping("/account/{id}")
    public double getBalance(@PathVariable long id) {
        System.out.println("getBalance id = " + id );
        double balance = accountService.getBalance(id);
        return balance;
    }
}
