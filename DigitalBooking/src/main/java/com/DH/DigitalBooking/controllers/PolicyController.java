package com.DH.DigitalBooking.controllers;

import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.City;
import com.DH.DigitalBooking.models.Policy;
import com.DH.DigitalBooking.models.Product;
import com.DH.DigitalBooking.services.PolicyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/city")
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

    @Operation(summary = "Adds a new Policy")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Policy successfully added"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content),
            @ApiResponse(responseCode = "400", description = "Policy already exists", content = @Content)
    })
    @PostMapping()
    public ResponseEntity addPolicy(@RequestBody Policy policy) throws CreatingExistingEntityException, EmptyFieldException {
        return ResponseEntity.ok(policyService.create(policy));
    }

    @Operation(summary = "Edits a policy")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Policy successfully updated"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Policy not found", content = @Content)
    })
    @PutMapping
    public ResponseEntity<Policy> editPolicy(@RequestBody Policy policy) throws ResourceNotFoundException, EmptyFieldException {
        return ResponseEntity.ok(policyService.edit(policy));
    }

    @Operation(summary = "Deletes a policy")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Policy successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body",content = @Content),
            @ApiResponse(responseCode = "404", description = "Policy not found", content = @Content)
    })
    @DeleteMapping
    public ResponseEntity<Policy> deletePolicy(@RequestBody Policy policy) throws ResourceNotFoundException, EmptyFieldException {
        return ResponseEntity.ok(policyService.delete(policy));
    }

    @Operation(summary = "Deletes a policy by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Policy successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request URL", content = @Content),
            @ApiResponse(responseCode = "404", description = "Policy Id not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Policy> deletePolicy(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(policyService.deleteById(id));
    }



}
