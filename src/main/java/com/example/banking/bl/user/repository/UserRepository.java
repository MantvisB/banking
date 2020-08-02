package com.example.banking.bl.user.repository;

import com.example.banking.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {}
