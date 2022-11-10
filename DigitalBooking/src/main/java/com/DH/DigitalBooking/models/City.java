package com.DH.DigitalBooking.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "city_sequence")
    @SequenceGenerator(name="city_sequence",sequenceName = "city_sequence")
    @Column(name="id",insertable=false,updatable=false)
    private Long id;
    @Column
    private String city_name;

    @Column
    private String country;

    public City() {
    }
    public City(String city_name, String country) {
        this.city_name = city_name;
        this.country = country;
    }

    public City(Long id, String city_name, String country) {
        this.id = id;
        this.city_name = city_name;
        this.country = country;
    }


}
