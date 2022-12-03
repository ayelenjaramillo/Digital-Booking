package com.DH.DigitalBooking.controllers;
import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.dto.ReservationBetweenDTO;
import com.DH.DigitalBooking.models.dto.ReservationDTO;
import com.DH.DigitalBooking.services.IReservationService;
import com.DH.DigitalBooking.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private IReservationService iReservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> findAll(){
        return ResponseEntity.ok(iReservationService.findAll());
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> save(@RequestBody ReservationDTO reservationProductDTO) throws CreatingExistingEntityException, EmptyFieldException, ResourceNotFoundException {
        if(reservationProductDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(iReservationService.save(reservationProductDTO));
        else
            return ResponseEntity.ok(iReservationService.save(reservationProductDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        iReservationService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(iReservationService.findById(id));
    }

    @PostMapping("/findBetweenDates")
    public ResponseEntity<List<ReservationDTO>> findByDate(@RequestBody ReservationBetweenDTO reservationBetweenDTO) throws ResourceNotFoundException {
        return ResponseEntity.ok(iReservationService.findBetweenTwoDates(reservationBetweenDTO.getCheckInDate(), reservationBetweenDTO.getCheckOutDate()));
    }

    @GetMapping("/findByProductId/{productId}")
    public ResponseEntity<List<ReservationDTO>> findByProductId(@PathVariable Long productId) throws ResourceNotFoundException {
        return ResponseEntity.ok(iReservationService.findByProductId(productId));
    }

    @GetMapping("/findAllByProductId/{productId}")
    public ResponseEntity<List<ReservationDTO>> findAllByProductId(@PathVariable Long productId) throws ResourceNotFoundException {
        return ResponseEntity.ok(iReservationService.findAllByProductId(productId));
    }

    @GetMapping("/findByUserId/{userId}")
    public ResponseEntity<List<ReservationDTO>>findByUserId(@PathVariable Long userId) throws ResourceNotFoundException {
        return ResponseEntity.ok(iReservationService.findByUserId(userId));
    }
}





