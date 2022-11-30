package com.DH.DigitalBooking.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    //@Column(name = "idReservations")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idReservation;

    //@Column (name = "check_in_time")
    @Column(name = "check_in_time")
    private LocalTime checkInTime;

    //@Column(name = "check_in_date")
    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    //@Column(name="check_out_date")
    @Column(name="check_out_date")
    private LocalDate checkOutDate;

    //TODO REVISAR NOMBRES DE COLUMNAS Y TABLAS EN BD
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id_user", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id_product",referencedColumnName = "id")
    private Product product;

    //all args SIN ID
    public Reservation(LocalTime check_in_time, LocalDate check_in_date, LocalDate check_out_date,  User user, Product product) {
    this.checkInTime = checkInTime;
    this.checkInDate= checkInDate;
    this.checkOutDate= checkOutDate;
    this.user= user;
    this.product= product;
    }
}
