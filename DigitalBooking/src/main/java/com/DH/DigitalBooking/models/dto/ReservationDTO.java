package com.DH.DigitalBooking.models.dto;

import com.DH.DigitalBooking.models.Product;
import com.DH.DigitalBooking.models.Reservation;
import com.DH.DigitalBooking.models.User;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationDTO {

    private LocalTime checkInTime;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private long productId;
    private long userId;

    public Reservation toReservation(){
        return new Reservation(this.getCheckInTime(),
                this.getCheckInDate(),
                this.getCheckOutDate(),
                new User(this.getUserId()),
                new Product(this.getProductId()));
    }


}
