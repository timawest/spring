package xyz.rbulatov.validator;

import org.springframework.stereotype.Component;
import xyz.rbulatov.dto.CustomerDto;
import xyz.rbulatov.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CustomerValidator {
    public void validate(CustomerDto customerDto){
        List<String> error = new ArrayList<>();
        if (Objects.isNull(customerDto.getFirstName())){
            error.add("Не заполнено Имя");
        }

        if (Objects.isNull(customerDto.getLastName())){
            error.add("Не заполнено Фамилия");
        }
        if (Objects.isNull(customerDto.getAge())) {
            error.add("Не заполнен возраст");
        }

        if (!error.isEmpty()){
            throw new ValidationException(error);
        }
    }
}
