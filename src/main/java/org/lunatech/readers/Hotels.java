package org.lunatech.readers;

import java.util.List;

import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.lunatech.models.Hotel;
import org.lunatech.quarkus.JsonController;
import org.lunatech.quarkus.Required;

import io.quarkus.panache.common.Sort;

/**
 * A resource service for read-only actions related to Hotels.
 */
// implicit @Path(controllername)
public class Hotels extends JsonController {

    // implicit GET for public methods
    public List<Hotel> get() {
        return Hotel.listAll(Sort.by("name"));
    }

    @Path("{hotelId}")
    public Hotel getDetails(@Required @PathParam String hotelId) {
        Hotel entity = Hotel.find("hotelId",hotelId).firstResult();
        notFoundIfNull(entity);
        return entity;
    }

}
