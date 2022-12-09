package com.DH.DigitalBooking.models.dto;

import com.DH.DigitalBooking.models.entities.Product;
import com.DH.DigitalBooking.models.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BookmarkDTO {
    private  Long id;
    @NotNull
    private Product product;
    @NotNull
    private User user;
}
