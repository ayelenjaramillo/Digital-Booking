package com.DH.DigitalBooking.controllers;
import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.dto.ReservationDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import com.DH.DigitalBooking.models.Reservation;
import com.DH.DigitalBooking.services.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Operation(summary = "Returns a list of all reservations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    @GetMapping
    public ResponseEntity<List<Reservation>> listReservations(){
        return ResponseEntity.ok(reservationService.listAll());
    }

    @Operation(summary = "Gets a specific reservation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation successfully returned"),
            @ApiResponse(responseCode = "400", description = "The requested reservation was not found", content = @Content)
    })
    @GetMapping ("/{id}")
    public ResponseEntity<Reservation> getReservationById (@PathVariable Long id) throws ResourceNotFoundException{
        return ResponseEntity.ok(reservationService.findById(id));
    }

    @Operation(summary = "Gets a list of reservations by products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation list successfully returned"),
    })

    @GetMapping("/product/{product_id}")
    public ResponseEntity<List<Reservation>> getReservationsByProductId(@PathVariable Long product_id) throws ResourceNotFoundException{
        return ResponseEntity.ok(reservationService.filterByProduct(product_id));
    }


    /* POST FUNCTIONS */
    @Operation(summary = "Adds a new reservation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation successfully added"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content),
            @ApiResponse(responseCode = "400", description = "Reservation already exists", content = @Content)
    })

   /* @PostMapping
    public ResponseEntity addReservation(@RequestBody Reservation reservation)throws CreatingExistingEntityException, EmptyFieldException, ResourceNotFoundException{

        //response.put("response", reservation);
        //response.put("message", "reservation made")
        return ResponseEntity.ok(reservationService.create(reservation));
    }*/


    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody ReservationDTO reservation)throws EmptyFieldException, CreatingExistingEntityException, ResourceNotFoundException{
        return ResponseEntity.ok(reservationService.create(reservation.toReservation()));
    }


    /* EDIT FUNCTIONS */
    @Operation(summary = "Edits a reservation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation successfully updated"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Reservation not found", content = @Content)
    })

    @PutMapping("/edit")
    public ResponseEntity editReservation(@RequestBody Reservation reservation) throws EmptyFieldException, ResourceNotFoundException {
        return ResponseEntity.ok(reservationService.edit(reservation));
    }

    /* DELETE FUNCTIONS */
    @Operation(summary = "Deletes a reservation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation successfully updated"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Reservation not found", content = @Content)
    })
    @DeleteMapping
    public ResponseEntity<Reservation> deleteReservation(@RequestBody Reservation reservation) throws EmptyFieldException, ResourceNotFoundException {
        return ResponseEntity.ok(reservationService.delete(reservation));
    }

    @Operation(summary = "Deletes a reservation by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation successfully updated"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Reservation Id not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable Long id) throws ResourceNotFoundException {
        return  ResponseEntity.ok(reservationService.deleteById(id));
    }

}
