package com.example.banking.controller;


import com.example.banking.bl.user.UserCreateView;
import com.example.banking.bl.user.service.UserService;
import com.example.banking.model.User;
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
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/new")
    public User createUser(@RequestBody @Valid UserCreateView userCreateView) {
        return userService.createUser(userCreateView);
    }
}
