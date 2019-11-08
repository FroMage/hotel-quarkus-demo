package org.lunatech.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.lunatech.dto.BookingRequest;
import org.lunatech.quarkus.JsonController;
import org.lunatech.quarkus.JsonEntity;
import org.lunatech.quarkus.Required;

/**
 * Service to create Booking request object.
 * Use application/json to deserialize object from the view.
 *
 * @author created by N.Martignole, Lunatech, on 2019-06-11.
 */
// implicit @Path(controllername)
public class BookingService extends JsonController {
    @POST
    @Path("hotel/{hotelId}")
    public JsonEntity create(@Required @PathParam String hotelId,
                             BookingRequest bookingRequest) {

        System.out.println("Booking request " + bookingRequest);

        validate(bookingRequest);

        return JsonEntity.result("booking created");
    }
}
