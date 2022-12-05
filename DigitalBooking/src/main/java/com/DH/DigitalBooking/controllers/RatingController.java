package com.DH.DigitalBooking.controllers;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.dto.RatingDTO;
import com.DH.DigitalBooking.services.RatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/ratings")
@CrossOrigin(origins = "*")
@Tag(name = "Puntuaciones")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @Operation(summary = "Create rating")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RatingDTO.class))}),
            @ApiResponse(responseCode = "409", description = "Incorrect format. Complete all required data.",
                    content = @Content)})
    @PostMapping
    public ResponseEntity<String> createRating(@Valid @RequestBody RatingDTO ratingDTO) throws ResourceNotFoundException {
        ratingService.addRating(ratingDTO);
        return ResponseEntity.ok("La puntuación se agregó al producto");
    }

    @Operation(summary = "Listar puntuaciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se listaron las puntuaciones correctamente.",
                    content = @Content)})
    @GetMapping
    public ResponseEntity<Set<RatingDTO>> listAllRatings() {
        return ResponseEntity.ok(ratingService.listAllRatings());
    }



}
