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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",insertable=false,updatable=false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "city_sequence")
    //@SequenceGenerator(name="city_sequence",sequenceName = "city_sequence")
    private Long id;
    @Column(name="city_name")
    private String cityName;

    @Column
    private String country;

    public City() {
    }
    public City(String city_name, String country) {
        this.cityName = city_name;
        this.country = country;
    }

    public City(Long id, String cityName, String country) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
    }


}
