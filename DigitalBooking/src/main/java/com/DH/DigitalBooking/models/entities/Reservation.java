package com.DH.DigitalBooking.models.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Long id;
    //private Long idReservation;

    @Column(name = "check_in_time")
    private Time checkInTime;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name="check_out_date")
    private LocalDate checkOutDate;

    //TODO REVISAR NOMBRES DE COLUMNAS Y TABLAS EN BD
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id_user", referencedColumnName = "id")
    @JsonIgnoreProperties
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id_product",referencedColumnName = "id")
    @JsonIgnoreProperties
    private Product product;

    //all args SIN ID
    public Reservation(Time checkInTime, LocalDate checkInDate, LocalDate checkOutDate,  User user, Product product) {
    this.checkInTime = checkInTime;
    this.checkInDate= checkInDate;
    this.checkOutDate= checkOutDate;
    this.user= user;
    this.product= product;
    }
}
