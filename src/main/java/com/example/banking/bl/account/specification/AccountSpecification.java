package com.example.banking.bl.account.specification;

import com.example.banking.bl.account.AccountSearch;
import com.example.banking.model.Account;
import com.example.banking.model.Account_;
import com.example.banking.model.User_;
import org.springframework.data.jpa.domain.Specification;

public class AccountSpecification {

    public static Specification<Account> build(AccountSearch search) {

        Specification<Account> specification = Specification.where(null);

        if (search.getUserIds() != null && !search.getUserIds().isEmpty()) {
            specification = specification.and((root, query, cb) -> root.join(Account_.user).get(User_.id).in(search.getUserIds()));
        }

        return specification;
    }
}
