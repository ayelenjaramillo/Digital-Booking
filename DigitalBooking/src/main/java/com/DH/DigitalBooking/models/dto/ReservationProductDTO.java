package com.DH.DigitalBooking.models.dto;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationProductDTO {

        private Integer id;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate checkInDate;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate checkOutDate;
        private LocalTime checkInTime;
        private Integer productId;
        private Integer userId;


}
