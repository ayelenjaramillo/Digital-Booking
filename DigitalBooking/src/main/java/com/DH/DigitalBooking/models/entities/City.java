package com.DH.DigitalBooking.models.entities;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",insertable=false,updatable=false)
    private Long id;
    @Column(name="city_name")
    private String cityName;
    @Column
    private String country;

    public City() {
    }
    public City(String cityName, String country) {
        this.cityName = cityName;
        this.country = country;
    }

    public City(Long id, String cityName, String country) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
    }


}
