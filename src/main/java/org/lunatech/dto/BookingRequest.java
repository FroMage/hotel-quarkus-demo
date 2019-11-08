package org.lunatech.dto;

import java.time.LocalDate;

import org.lunatech.quarkus.Validatable;
import org.lunatech.quarkus.ValidatorContext;

/**
 * @author created by N.Martignole, Lunatech, on 2019-06-11.
 */
public class BookingRequest implements Validatable {
    public String hotelId;
    public LocalDate checkinDate;
    public LocalDate checkoutDate;

    @Override
    public String toString() {
        return "BookingRequest hotelId=" + this.hotelId +
                " checkinDate=" + this.checkinDate +
                " checkoutDate=" + this.checkoutDate;
    }

    public void isValid(ValidatorContext context) {
        if (checkoutDate.isBefore(checkinDate)) {
            context.addError("Check-out date must be strictly after the checkin date");
        } else if (checkinDate.isBefore(LocalDate.now())) {
            context.addError("Check-in date must be today or after");
        }
    }
}
