package com.example.banking.bl.account;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AccountOperationView {

    @NotNull
    private Long accountId;

    @NotNull
    private Double value;

}
