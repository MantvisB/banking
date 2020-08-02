package com.example.banking.bl.user.specification;

import com.example.banking.bl.user.UserSearch;
import com.example.banking.model.User;
import com.example.banking.model.User_;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor
public class UserSpecification {

    public static Specification<User> build(UserSearch search) {

        Specification<User> specification = Specification.where(null);

        if (search.getEmail() != null) {
            specification = specification.and((root, query, cb) -> cb.equal(root.get(User_.email), search.getEmail()));
        }

        return specification;
    }
}
