package org.lunatech.quarkus;


public interface Validatable {
    public void isValid(ValidatorContext context);
}
