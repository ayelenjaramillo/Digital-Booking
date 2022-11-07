package com.DH.DigitalBooking.models;

import lombok.*;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DTOProductBuilder extends Product{

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

    public Product toProduct(){
        return new Product(title, description_title, description, rating, address,
                new Category(category_id, null, null, null),
                new City(city_id,null, null), images,features,"Aquí van las políticas de este establecimiento");
    }

}
