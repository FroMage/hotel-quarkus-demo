package org.lunatech.dto;

import io.vavr.control.Either;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author created by N.Martignole, Lunatech, on 2019-06-11.
 */
public class BookingRequest {
    public String hotelId;
    public LocalDate checkinDate;
    public LocalDate checkoutDate;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String toString() {
        return "BookingRequest hotelId=" + this.hotelId +
                " checkinDate=" + this.checkinDate +
                " checkoutDate=" + this.checkoutDate;
    }

    // See https://www.baeldung.com/vavr-either
    public Either<String, String> isValid() {
        if (checkoutDate.isBefore(checkinDate)) {
            return Either.left("Check-out date must be strictly after the checkin date");
        }
        if (checkinDate.isBefore(LocalDate.now())) {
            return Either.left("Check-in date must be today or after");
        }

        return Either.right("Valid"); // Void or Unit ?

    }
}
