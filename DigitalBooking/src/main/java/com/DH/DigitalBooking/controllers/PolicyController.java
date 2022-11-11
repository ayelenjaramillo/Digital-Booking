package com.DH.DigitalBooking.controllers;

import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.Policy;
import com.DH.DigitalBooking.services.PolicyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;
    @Operation(summary = "Returns a Policy object with the specified id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Policy> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(policyService.findById(id));
    }



}
