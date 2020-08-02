package com.example.banking.bl.statement.repository;

import com.example.banking.model.Statement;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementRepository extends CrudRepository<Statement, Long>, JpaSpecificationExecutor<Statement> {}
