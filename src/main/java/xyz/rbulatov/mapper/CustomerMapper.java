package xyz.rbulatov.mapper;

import org.springframework.stereotype.Component;
import xyz.rbulatov.dto.CustomerDto;
import xyz.rbulatov.model.Customer;

@Component
public class CustomerMapper {
    public Customer dtoToEntity(CustomerDto dto){
        return new Customer(dto.getId(), dto.getLastName(), dto.getFirstName(), dto.getAge());
    }

    public CustomerDto entityToDto(Customer entity){
        return new CustomerDto(entity.getId(), entity.getLastName(), entity.getFirstName(), entity.getAge());
    }

}

