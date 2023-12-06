package xyz.rbulatov.service;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.rbulatov.dto.CustomerDto;
import xyz.rbulatov.exception.ResourceNotFoundException;
import xyz.rbulatov.model.Customer;
import xyz.rbulatov.repository.CustomerRepository;
import xyz.rbulatov.repository.specifications.CustomerSpecifications;

import java.util.List;
import java.util.Optional;

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

    public Customer saveNewCustomer(Customer customer){
        return repository.save(customer);
    }
    @Transactional
    public Customer updateCustomer(CustomerDto customerDto){
        Customer customer = repository.findById(customerDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить пользователя"));
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setAge(customerDto.getAge());
        return customer;
    }

    public Optional<Customer> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
