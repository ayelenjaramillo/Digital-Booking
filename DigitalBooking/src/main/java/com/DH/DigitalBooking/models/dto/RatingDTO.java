package com.DH.DigitalBooking.models.dto;
import com.DH.DigitalBooking.models.entities.Product;
import com.DH.DigitalBooking.models.entities.User;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RatingDTO {
    private Long id;
    @NotNull
    private Integer rating;
    @NotNull
    private Product product;
    @NotNull
    private User user;

}
