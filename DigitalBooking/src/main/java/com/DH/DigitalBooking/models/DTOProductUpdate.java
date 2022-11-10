package com.DH.DigitalBooking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class DTOProductUpdate {

    private Long id;
    private String title;
    private String description_title;
    private String description;
    private Integer rating;
    private String address;
    private long category_id;
    private long city_id;
    //the return value of "com.DH.DigitalBooking.models.DTOProductBuilder.getCity()" is null
    private Set<Image> images = new HashSet<>();
    private Set<Feature> features = new HashSet<>();
    private String policy;
}
