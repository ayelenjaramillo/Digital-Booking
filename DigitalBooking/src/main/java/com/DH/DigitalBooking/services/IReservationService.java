package com.DH.DigitalBooking.services;
import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.Reservation;
import com.DH.DigitalBooking.models.dto.ReservationDTO;
import com.DH.DigitalBooking.models.dto.ReservationProductDTO;
import java.time.LocalDate;
import java.util.List;

public interface IReservationService extends ICheckId<Reservation>{

    public void saveReservations(List<Reservation> reservationsList);
    ReservationDTO save(ReservationDTO reservationDTO) throws CreatingExistingEntityException, EmptyFieldException, ResourceNotFoundException;
    ReservationDTO findById(Long id) throws ResourceNotFoundException;
    List<ReservationDTO> findAll();
    void delete(Long id) throws ResourceNotFoundException;
    List <ReservationDTO> findBetweenTwoDates(LocalDate checkInDate, LocalDate checkOutDate) throws ResourceNotFoundException;
    List <ReservationDTO> findByProductId(Long productId) throws ResourceNotFoundException;
    List<ReservationDTO> findByUserId(Long id) throws ResourceNotFoundException;
    List <ReservationDTO> findAllByProductId(Long productId) throws ResourceNotFoundException;



}
