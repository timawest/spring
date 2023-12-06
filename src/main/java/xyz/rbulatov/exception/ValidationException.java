package xyz.rbulatov.exception;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
@Data
public class ValidationException extends RuntimeException{
    private List<String> errorFieldsMessages;
    public ValidationException(List<String> errorFieldsMessages){ super(String.join(", ", errorFieldsMessages));
    this.errorFieldsMessages = errorFieldsMessages;}
}
