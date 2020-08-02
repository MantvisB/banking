package com.example.banking.bl.account.service;

import com.example.banking.bl.account.AccountCreateView;
import com.example.banking.bl.account.AccountOperationView;
import com.example.banking.bl.account.AccountSearch;
import com.example.banking.model.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(AccountCreateView accountCreateView);

    void deposit(AccountOperationView accountOperationView);

    void withdraw(AccountOperationView accountOperationView);

    List<Account> findAccounts(AccountSearch accountSearch);
}
