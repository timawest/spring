package xyz.rbulatov.service;

import org.springframework.stereotype.Service;
import xyz.rbulatov.model.Customer;
import xyz.rbulatov.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAllCustomers(){
        return repository.findAll();
    }
}
