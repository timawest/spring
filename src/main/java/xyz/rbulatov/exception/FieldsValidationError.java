package xyz.rbulatov.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class FieldsValidationError{
    private List<String> errorFieldsMesages;
    public FieldsValidationError(List<String> errorFieldsMesages) {
        this.errorFieldsMesages = errorFieldsMesages;
    }





}
