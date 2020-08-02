package com.example.banking.controller;

import com.example.banking.bl.statement.StatementSearch;
import com.example.banking.bl.statement.service.StatementService;
import com.example.banking.model.Statement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statement")
public class StatementController {


    private final StatementService statementService;

    @GetMapping("/find")
    public List<Statement> findStatements(@RequestBody StatementSearch statementSearch) {
        return statementService.findStatements(statementSearch);
    }
/*
    @PostMapping("/new-user")
    public User createUser(@RequestBody @Valid UserCreateView userCreateView) {
        return userService.createUser(userCreateView);
    }

*/

}
