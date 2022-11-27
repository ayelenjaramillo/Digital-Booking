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
        private LocalDate check_ot_date;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate check_out_date;
        private LocalTime check_in_time;
        private Integer productId;
        private Integer userId;


}
