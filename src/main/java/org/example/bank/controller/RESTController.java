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
@RequestMapping("/api")
public class RESTController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public List<Account> showAllAccounts() {
        System.out.println("showAllAccounts");
        return accountService.showAllAccounts();
    }

    @GetMapping("/account/{id}")
    public double getBalance(@PathVariable long id) {
        System.out.println("getBalance id = " + id );
        return accountService.getBalance(id);
    }
}
