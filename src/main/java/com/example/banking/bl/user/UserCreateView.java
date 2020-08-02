package com.example.banking.bl.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
public class UserCreateView {
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@.+$")
    @NotNull
    private String email;

    @Size(min = 5)
    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;




}
