package xyz.rbulatov.api;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.rbulatov.model.Customer;
import xyz.rbulatov.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
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
}
