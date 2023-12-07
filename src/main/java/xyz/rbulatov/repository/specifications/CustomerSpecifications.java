package xyz.rbulatov.repository.specifications;

import org.springframework.data.jpa.domain.Specification;
import xyz.rbulatov.model.Customer;

public class CustomerSpecifications {
    public static Specification<Customer> greaterThanOrEqualTo(Integer minAge){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("age"), minAge));
    }

    public static Specification<Customer> lessThanOrEqualTo(Integer maxAge){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("age"), maxAge));
    }

    public static Specification<Customer> lastNameLike(String lastName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("lastName"), String.format("%%%s%%",lastName)));
    }
}
