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

    private LocalTime check_in_time;
    private LocalDate check_in_date;
    private LocalDate check_out_date;
    private long product_id;
    private long user_id;

    public Reservation toReservation(){
        return new Reservation(this.getCheck_in_time(),
                this.getCheck_in_date(),
                this.getCheck_out_date(),
                new User(this.getUser_id()),
                new Product(this.getProduct_id()));
    }


}
