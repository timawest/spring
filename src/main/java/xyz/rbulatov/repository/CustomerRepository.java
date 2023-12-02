package xyz.rbulatov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.rbulatov.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
