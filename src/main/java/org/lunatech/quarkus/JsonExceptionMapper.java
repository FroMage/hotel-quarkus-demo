package org.lunatech.quarkus;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

// No @Provider as we want this to be opt-in
public class JsonExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        int code = 500;
        if (exception instanceof WebApplicationException) {
            code = ((WebApplicationException) exception).getResponse().getStatus();
        }
        return Response.status(code)
                .entity(JsonEntity.error(code, exception.getMessage()))
                .build();
    }
}
