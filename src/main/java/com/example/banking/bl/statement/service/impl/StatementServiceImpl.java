package com.example.banking.bl.statement.service.impl;

import com.example.banking.bl.statement.StatementSearch;
import com.example.banking.bl.statement.repository.StatementRepository;
import com.example.banking.bl.statement.service.StatementService;
import com.example.banking.bl.statement.specification.StatementSpecification;
import com.example.banking.model.Statement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatementServiceImpl implements StatementService {

    private final StatementRepository statementRepository;

    @Override
    public void save(Statement statement) {
        statementRepository.save(statement);
    }

    @Override
    public List<Statement> findStatements(StatementSearch statementSearch) {
        return statementRepository.findAll(StatementSpecification.build(statementSearch));
    }

}
