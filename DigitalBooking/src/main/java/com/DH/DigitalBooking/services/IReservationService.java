package com.DH.DigitalBooking.services;
import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.entities.Reservation;
import com.DH.DigitalBooking.models.dto.ReservationDTO;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService extends ICheckId<Reservation>{

    public void saveReservations(List<Reservation> reservationsList);
    ReservationDTO save(ReservationDTO reservationDTO) throws CreatingExistingEntityException, EmptyFieldException, ResourceNotFoundException;
    ReservationDTO findById(Long id) throws ResourceNotFoundException;
    List<ReservationDTO> findAll();
    void delete(Long id) throws ResourceNotFoundException;
    List <ReservationDTO> findBetweenTwoDates(LocalDate checkInDate, LocalDate checkOutDate) throws ResourceNotFoundException;
    List <ReservationDTO> findReservationByProductId(Long productId) throws ResourceNotFoundException;
    List<ReservationDTO> findReservationByUserId(Long id) throws ResourceNotFoundException;
    List <ReservationDTO> findAllByProductId(Long productId) throws ResourceNotFoundException;



}
