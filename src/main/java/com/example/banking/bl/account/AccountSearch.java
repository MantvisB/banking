package com.example.banking.bl.account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class AccountSearch {

    private List<Long> userIds;

}
