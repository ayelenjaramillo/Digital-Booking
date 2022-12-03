package com.DH.DigitalBooking.models.dto;
import com.DH.DigitalBooking.models.Category;
import com.DH.DigitalBooking.models.City;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DTOProductCityCategory {

    private Long id;
    private String title;
    private String descriptionTitle;
    private City city;
    private Category category;



}
