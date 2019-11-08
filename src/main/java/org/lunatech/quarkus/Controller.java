package org.lunatech.quarkus;

import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

// Implicit @ApplicationScoped on subclasses
public abstract class Controller {
    
    @Inject
    protected Validator validator;
    
    protected void validate(Object entity) {
        Set<ConstraintViolation<Object>> errors = validator.validate(entity);
        if(!errors.isEmpty()) {
            String message = errors.stream()
                    .map(cv -> cv.getMessage())
                    .collect(Collectors.joining(", "));
            throw new WebApplicationException(message, Status.BAD_REQUEST);
        }
    }

    protected void notFoundIfNull(Object object) {
        if(object == null)
            throw new WebApplicationException(Status.NOT_FOUND);
    }

    protected Response ok(Object entity) {
        return Response.ok(entity).build();
    }
}
