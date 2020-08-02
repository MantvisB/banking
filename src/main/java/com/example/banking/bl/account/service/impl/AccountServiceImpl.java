package com.example.banking.bl.account.service.impl;

import com.example.banking.bl.account.AccountCreateView;
import com.example.banking.bl.account.AccountOperationView;
import com.example.banking.bl.account.AccountSearch;
import com.example.banking.bl.account.repository.AccountRepository;
import com.example.banking.bl.account.service.AccountService;
import com.example.banking.bl.account.specification.AccountSpecification;
import com.example.banking.bl.enums.Action;
import com.example.banking.bl.statement.service.StatementService;
import com.example.banking.bl.user.repository.UserRepository;
import com.example.banking.model.Account;
import com.example.banking.model.Statement;
import com.example.banking.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final StatementService statementService;

    @Override
    public Account createAccount(AccountCreateView accountCreateView) {
        User user = userRepository.findById(accountCreateView.getUserId()).orElseThrow(() -> new IllegalArgumentException("cannot find User with given id = "+ accountCreateView.getUserId()));
        Account account = new Account();
        account.setBalance(accountCreateView.getBalance());
        account.setUser(user);
        accountRepository.save(account);
        return account;
    }

    @Override
    public void deposit(AccountOperationView accountOperationView) {

        Account account = accountRepository.findById(accountOperationView.getAccountId()).orElseThrow(() ->
                new IllegalArgumentException("cannot find Account with given id = " + accountOperationView.getAccountId()));
        Double value =  round(accountOperationView.getValue());

        account.setBalance(account.getBalance() + value);
        Statement statement = Statement.builder()
                .action(Action.DEPOSIT)
                .value(value)
                .account(account)
                .time(LocalDateTime.now())
                .build();
        accountRepository.save(account);
        statementService.save(statement);
    }

    @Override
    public void withdraw(AccountOperationView accountOperationView) {
        Account account = accountRepository.findById(accountOperationView.getAccountId()).orElseThrow(() ->
                new IllegalArgumentException("cannot find Account with given id = " + accountOperationView.getAccountId()));
        Double balance = account.getBalance();
        Double value =  round(accountOperationView.getValue());
        if (balance - value < 0) {
            throw new IllegalArgumentException("The transaction cannot be processed, you do not have sufficient funds in your account.");
        }
        account.setBalance(account.getBalance() - round(value));
        Statement statement = Statement.builder()
                .action(Action.WITHDRAW)
                .value(value)
                .account(account)
                .time(LocalDateTime.now())
                .build();
        accountRepository.save(account);
        statementService.save(statement);
    }

    @Override
    public List<Account> findAccounts(AccountSearch accountSearch) {
        return accountRepository.findAll(AccountSpecification.build(accountSearch));
    }

    private static Double round(Double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
