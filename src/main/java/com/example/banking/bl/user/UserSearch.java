package com.example.banking.bl.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class UserSearch {

    private List<Long> ids;
    private String email;
    private String firstname;
    private String lastname;

}
