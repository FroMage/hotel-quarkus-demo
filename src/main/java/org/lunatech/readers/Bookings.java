package org.lunatech.readers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.lunatech.models.Booking;
import org.lunatech.quarkus.JsonController;
import org.lunatech.quarkus.Required;

/**
 * A service for read-only actions.
 */
// implicit @Path(controllername)
public class Bookings extends JsonController {
    
    // implicit @GET for public methods
    @Path("hotel/{id}")
    public List<Booking> allForHotel(@Required @PathParam Long id) {
        Stream<Booking> bookings = Booking.stream("hotel_id", id);
        return bookings
                .map(Booking::clearCreditCard)
                .collect(Collectors.toList());
    }

    @Path("hotel/{hotelId}/counter")
    public Long counterForHotel(@Required @PathParam String hotelId) {
        return Booking.count("hotelid", hotelId);
    }

    @Path("ref/{bookingRef}")
    public Booking findByReference(@PathParam UUID bookingRef) {
        Booking booking = Booking.find("bookingRef", bookingRef).firstResult();
        notFoundIfNull(booking);
        return booking;
    }
}
