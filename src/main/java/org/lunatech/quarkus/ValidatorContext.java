package org.lunatech.quarkus;

import javax.validation.ConstraintValidatorContext;

public interface ValidatorContext extends ConstraintValidatorContext {
    
    public default void addError(String message) {
        buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}
