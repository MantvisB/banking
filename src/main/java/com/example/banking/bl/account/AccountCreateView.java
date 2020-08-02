package com.example.banking.bl.account;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AccountCreateView {

    @NotNull
    private Long userId;

    @NotNull
    private Double balance;

}
