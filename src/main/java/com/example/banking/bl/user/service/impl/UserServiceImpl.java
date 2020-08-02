package com.example.banking.bl.user.service.impl;

import com.example.banking.bl.user.UserCreateView;
import com.example.banking.bl.user.UserSearch;
import com.example.banking.bl.user.repository.UserRepository;
import com.example.banking.bl.user.service.UserService;
import com.example.banking.bl.user.specification.UserSpecification;
import com.example.banking.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("cannot find user with given id=" + id));
    }

    public List<User> getUserByEmail(String email) {
        UserSearch search = UserSearch.builder()
                .email(email)
                .build();
        return userRepository.findAll(UserSpecification.build(search));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Specification.where(null));
    }


    @Override
    public User createUser(UserCreateView userCreateView) {
        User user = User.builder()
                .email(userCreateView.getEmail())
                .password(userCreateView.getPassword())
                .firstName(userCreateView.getFirstName())
                .lastName(userCreateView.getLastName())
                .build();
        userRepository.save(user);
        return user;
    }
}
