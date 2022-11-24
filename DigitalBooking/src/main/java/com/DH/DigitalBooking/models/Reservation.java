package com.DH.DigitalBooking.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reservations")
public class Reservation {

    @Id
    //@Column(name = "idReservations")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idReservation;

    //@Column (name = "check_in_time")
    @Column
    private LocalTime check_in_time;

    //@Column(name = "check_in_date")
    @Column
    private Date check_in_date;

    //@Column(name="check_out_date")
    @Column
    private Date check_out_date;

    //TODO REVISAR NOMBRES DE COLUMNAS Y TABLAS EN BD
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products_id",referencedColumnName = "id")
    private Product product;

    //all args SIN ID
    public Reservation(LocalTime check_in_time, Date check_in_date, Date check_out_date,  User user, Product product) {
    this.check_in_time = check_in_time;
    this.check_in_date= check_in_date;
    this.check_out_date= check_out_date;
    this.user= user;
    this.product= product;
    }
}
