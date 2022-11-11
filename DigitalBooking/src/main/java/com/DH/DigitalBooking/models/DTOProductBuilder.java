package com.DH.DigitalBooking.models;
import lombok.*;
import java.util.HashSet;
import java.util.Set;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class DTOProductBuilder {

    private String title;
    private String description_title;
    private String description;
    private Integer rating;
    private String address;
    private long category_id;
    private long city_id;
    private Set<Image> images = new HashSet<>();
    private Set<Feature> features = new HashSet<>();
    private String policy;

    //metodo privado en service que haga la tranformacion //2 responsabilidades
}
