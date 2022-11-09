package com.DH.DigitalBooking.models;
import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "city_sequence")
    @SequenceGenerator(name="city_sequence",sequenceName = "city_sequence")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }




}
