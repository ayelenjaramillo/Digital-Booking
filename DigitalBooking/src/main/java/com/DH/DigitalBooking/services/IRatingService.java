package com.DH.DigitalBooking.services;

import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.dto.RatingDTO;
import com.DH.DigitalBooking.models.entities.Rating;

import java.util.Set;

public interface IRatingService {

    Rating addRating(RatingDTO ratingDTO) throws ResourceNotFoundException;
    Set<RatingDTO> listAllRatings();

}
