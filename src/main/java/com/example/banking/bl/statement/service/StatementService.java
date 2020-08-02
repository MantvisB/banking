package com.example.banking.bl.statement.service;

import com.example.banking.bl.statement.StatementSearch;
import com.example.banking.model.Statement;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface StatementService {

    void save(Statement statement);

    List<Statement> findStatements(StatementSearch statementSearch);

}
