package com.DH.DigitalBooking.models.dto;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationDTO {

    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkInDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOutDate;
    private LocalTime checkInTime;
    private Long productId;
    private Long userId;

    /*public Reservation toReservation(){
        return new Reservation(this.getCheckInTime(),
                this.getCheckInDate(),
                this.getCheckOutDate(),
                new User(this.getUserId()),
                new Product(this.getProductId()));
    }*/


}
