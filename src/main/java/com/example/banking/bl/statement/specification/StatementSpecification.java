package com.example.banking.bl.statement.specification;

import com.example.banking.bl.statement.StatementSearch;
import com.example.banking.model.Account_;
import com.example.banking.model.Statement;
import com.example.banking.model.Statement_;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor
public class StatementSpecification {

    public static Specification<Statement> build(StatementSearch search) {

        Specification<Statement> specification = Specification.where(null);

        if (search.getAction() != null) {
            specification = specification.and((root, query, cb) -> cb.equal(root.get(String.valueOf(Statement_.action)), search.getAction()));
        }

        if (search.getAccountIds() != null && !search.getAccountIds().isEmpty()) {
            specification = specification.and((root, query, cb) -> root.join(Statement_.account).get(Account_.id).in(search.getAccountIds()));
        }

        if (search.getTimeFrom() != null) {
            specification = specification.and((root, query, cb) -> cb.greaterThanOrEqualTo(root.get(Statement_.time), search.getTimeFrom()));
        }

        if (search.getTimeTo() != null) {
            specification = specification.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get(Statement_.time), search.getTimeTo()));
        }

        return specification;
    }
}
