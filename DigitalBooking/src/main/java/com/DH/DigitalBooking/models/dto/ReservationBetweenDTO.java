package com.DH.DigitalBooking.models.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationBetweenDTO {

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate checkInDate;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate checkOuDate;



}
