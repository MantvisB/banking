package com.example.banking.controller;


import com.example.banking.bl.account.AccountCreateView;
import com.example.banking.bl.account.AccountOperationView;
import com.example.banking.bl.account.AccountSearch;
import com.example.banking.bl.account.service.AccountService;
import com.example.banking.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<Account> findAccounts(AccountSearch accountSearch) {
        return accountService.findAccounts(accountSearch);
    }

    @PostMapping("/new")
    public void newAccount(@RequestBody @Valid AccountCreateView accountCreateView) {
        accountService.createAccount(accountCreateView);
    }


    @PostMapping("/deposit")
    public void deposit(@RequestBody @Valid AccountOperationView accountOperationView) {
        accountService.deposit(accountOperationView);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestBody @Valid AccountOperationView accountOperationView) {
        accountService.withdraw(accountOperationView);
    }



}
