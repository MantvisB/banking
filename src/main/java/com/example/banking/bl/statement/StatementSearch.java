package com.example.banking.bl.statement;

import com.example.banking.bl.enums.Action;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
public class StatementSearch {

    private List<Long> accountIds;
    private Action action;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;

}
