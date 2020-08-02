package com.example.banking.bl.account.repository;

import com.example.banking.model.Account;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long>, JpaSpecificationExecutor<Account> {}
