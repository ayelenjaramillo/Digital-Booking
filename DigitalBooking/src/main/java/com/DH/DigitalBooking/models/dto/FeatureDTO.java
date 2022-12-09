package com.DH.DigitalBooking.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FeatureDTO {

    private Long id;
   // @NotNull
    private String description;
    //@NotNull
    private String icon;

}
