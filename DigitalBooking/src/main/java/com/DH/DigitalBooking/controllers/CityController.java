package com.DH.DigitalBooking.controllers;

import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.City;
import com.DH.DigitalBooking.services.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @Operation(summary = "Returns a list of cities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    @GetMapping
    public ResponseEntity<List<City>> listLocations() {
        return ResponseEntity.ok(cityService.listAll());
    }

    @Operation(summary = "Gets a specific city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City successfully returned"),
            @ApiResponse(responseCode = "400", description = "The requested city was not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<City> getLocation(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(cityService.findById(id));
    }

    @Operation(summary = "Adds a new city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City successfully added"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content),
            @ApiResponse(responseCode = "400", description = "City already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity<City> addLocation(@RequestBody City location) throws EmptyFieldException, CreatingExistingEntityException, ResourceNotFoundException {
        return ResponseEntity.ok(cityService.create(location));
    }

    @Operation(summary = "Edits a city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City successfully updated"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "City not found", content = @Content)
    })
    @PutMapping
    public ResponseEntity<City> editLocation(@RequestBody City location) throws ResourceNotFoundException, EmptyFieldException {
        return ResponseEntity.ok(cityService.edit(location));
    }

    @Operation(summary = "Deletes a city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body",content = @Content),
            @ApiResponse(responseCode = "404", description = "City not found", content = @Content)
    })
    @DeleteMapping
    public ResponseEntity<City> deleteLocation(@RequestBody City location) throws ResourceNotFoundException, EmptyFieldException {
        return ResponseEntity.ok(cityService.delete(location));
    }

    @Operation(summary = "Deletes a city by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request URL", content = @Content),
            @ApiResponse(responseCode = "404", description = "City Id not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(cityService.deleteById(id));
    }



}
