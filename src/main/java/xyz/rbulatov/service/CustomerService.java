package xyz.rbulatov.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.rbulatov.model.Customer;
import xyz.rbulatov.repository.CustomerRepository;
import xyz.rbulatov.repository.specifications.CustomerSpecifications;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public Page<Customer> find(Integer minAge, Integer maxAge, String partName, Integer page){
        Specification<Customer> spec = Specification.where(null);
        if(minAge != null){
            spec = spec.and(CustomerSpecifications.greaterThanOrEqualTo(minAge));
        }

        if(maxAge != null){
            spec = spec.and(CustomerSpecifications.lessThanOrEqualTo(maxAge));
        }
        if(partName != null){
            spec = spec.and(CustomerSpecifications.lastNameLike(partName));
        }
        return repository.findAll(spec, PageRequest.of(page - 1, 5));
    }

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAllCustomers(){
        return repository.findAll();
    }
}
