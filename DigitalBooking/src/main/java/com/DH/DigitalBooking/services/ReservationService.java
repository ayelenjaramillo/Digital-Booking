package com.DH.DigitalBooking.services;
import com.DH.DigitalBooking.models.dto.ReservationBetweenDTO;
import com.DH.DigitalBooking.models.dto.ReservationDTO;
import com.DH.DigitalBooking.models.dto.ReservationProductDTO;
import com.DH.DigitalBooking.repositories.ReservationRepository;
import com.DH.DigitalBooking.models.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;


import com.DH.DigitalBooking.util.MapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IService<Reservation> {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private IUserService userService;


    @Autowired
    private UserServiceImpl userServiceImp;

    @Autowired
    private ProductService productService;


    @Autowired
    ObjectMapper mapper;


    @Override
    public List<Reservation> listAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) throws ResourceNotFoundException {
        Optional<Reservation> result = reservationRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new ResourceNotFoundException("Could not find specified resource.");
        }
    }

    public List<Reservation> findByUserId(Long id){
        return reservationRepository.findAllByUserId(id);
    }

    @Override
    public Reservation create(Reservation reservation) throws EmptyFieldException, CreatingExistingEntityException, ResourceNotFoundException {
        reservation.setProduct(productService.findById(reservation.getProduct().getId()));
        reservation.setUser(userServiceImp.findById(reservation.getUser().getId()));

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation edit(Reservation t) throws ResourceNotFoundException, EmptyFieldException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reservation delete(Reservation t) throws ResourceNotFoundException, EmptyFieldException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reservation deleteById(Long id)  throws ResourceNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Reservation> filterByProduct(Long product_id) throws ResourceNotFoundException{
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
