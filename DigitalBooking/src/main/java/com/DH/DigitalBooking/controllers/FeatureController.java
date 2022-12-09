package com.DH.DigitalBooking.controllers;


import com.DH.DigitalBooking.models.dto.FeatureDTO;
import com.DH.DigitalBooking.services.FeatureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/features")
@CrossOrigin(origins = "*")
@Tag(name = "Características")
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @Operation(summary = "List  features")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All the features ok",
                    content = @Content)})
    @GetMapping
    public ResponseEntity<Set<FeatureDTO>> listNonRepeatedFeatures(){
        return ResponseEntity.ok(featureService.listNonRepeatedFeatures());
    }


}
