package org.lunatech.quarkus;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@WithExceptionMapper(JsonExceptionMapper.class)
public class JsonController extends Controller {
}
