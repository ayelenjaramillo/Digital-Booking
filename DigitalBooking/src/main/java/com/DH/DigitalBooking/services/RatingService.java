package com.DH.DigitalBooking.services;

import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.dto.RatingDTO;
import com.DH.DigitalBooking.models.entities.Rating;
import com.DH.DigitalBooking.repositories.RatingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RatingService implements IRatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    ObjectMapper mapper;

    //@Autowired
    //private static final Logger logger = Logger.getLogger(PuntuacionService.class);

    @Override
    public Rating addRating(RatingDTO ratingDTO)  throws ResourceNotFoundException{
        if(ratingDTO.getRating()==null || ratingDTO.getProduct()==null || ratingDTO.getUser()==null)
            throw  new ResourceNotFoundException("Intenta crear una puntuación incompleta. Todos los datos son requeridos");
        Rating rating = mapper.convertValue(ratingDTO, Rating.class);
        //logger.info("La puntuación se agregó correctamente");
        return ratingRepository.save(rating);
    }


    @Override
    public Set<RatingDTO> listAllRatings() {
        List<Rating> ratings= ratingRepository.findAll();
        Set<RatingDTO> ratingDTOS= new HashSet<>();

        for(Rating rating:ratings){
            ratingDTOS.add(mapper.convertValue(rating, RatingDTO.class));
        }
        //logger.info("Las puntuaciones se listaron correctamente");
        return ratingDTOS;
    }

}
