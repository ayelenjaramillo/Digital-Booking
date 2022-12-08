package com.DH.DigitalBooking.models.dto;
import com.DH.DigitalBooking.models.entities.*;
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

    private Long categoryId;
    private Long cityId;

    private Set<Image> images = new HashSet<>();
    private Set<Feature> features = new HashSet<>();

    //private String policy;

    //metodo privado en service que haga la tranformacion //2 responsabilidades
    private Product toProduct(DTOProductBuilder dtoProductBuilder){
        return new Product(dtoProductBuilder.getTitle(), dtoProductBuilder.getDescription(), dtoProductBuilder.getDescription_title(), dtoProductBuilder.getRating(), dtoProductBuilder.getAddress(),
                new Category( null, null, null),
                new City(dtoProductBuilder.getCityId(), null, null),
                images, features, new Policy(null, null));
    }

}
