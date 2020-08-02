package com.example.banking.bl.user.service;

import com.example.banking.bl.user.UserCreateView;
import com.example.banking.model.User;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface UserService {

    User getUserById(Long id);

    List<User> getAllUsers();

    User createUser(UserCreateView userCreateView);
}
