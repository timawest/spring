package xyz.rbulatov.api;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import xyz.rbulatov.dto.CustomerDto;
import xyz.rbulatov.exception.ResourceNotFoundException;
import xyz.rbulatov.mapper.CustomerMapper;
import xyz.rbulatov.model.Customer;
import xyz.rbulatov.service.CustomerService;
import xyz.rbulatov.validator.CustomerValidator;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final CustomerValidator customerValidator;

    @GetMapping
    public Page<Customer> findAllCustomers(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                           @RequestParam(name = "min_age", required = false) Integer minAge,
                                           @RequestParam(name = "max_age", required = false) Integer maxAge,
                                           @RequestParam(name = "part_name", required = false) String partName){
        if(page < 1){
            page = 1;
        }

        return customerService.find(minAge, maxAge, partName, page);

    }

    @GetMapping("/all")
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto findById(@PathVariable Long id){
        Customer customer = customerService.findById(id).orElseThrow((()-> new ResourceNotFoundException("Customer not found")));
        return customerMapper.entityToDto(customer);
    }

    @PostMapping()
    public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto){
        customerValidator.validate(customerDto);
        Customer customer = customerMapper.dtoToEntity(customerDto);
        customer = customerService.saveNewCustomer(customer);
        return customerMapper.entityToDto(customer);
    }

    @PutMapping()
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto){
        customerValidator.validate(customerDto);
        Customer customer = customerService.updateCustomer(customerDto);
        return customerMapper.entityToDto(customer);
    }

    @DeleteMapping("/{id}")
    public void saveCustomer(@PathVariable Long id){
        customerService.deleteById(id);
    }
}
