package com.DH.DigitalBooking.controllers;
import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.DTOProductBuilder;
import com.DH.DigitalBooking.models.DTOProductUpdate;
import com.DH.DigitalBooking.models.Product;
import com.DH.DigitalBooking.services.ProductService;
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
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation(summary = "Returns a list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    @GetMapping
    public ResponseEntity<List<Product>> listProducts(){
        return ResponseEntity.ok(productService.listAll());
    }


    @Operation(summary = "Gets a specific product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully returned"),
            @ApiResponse(responseCode = "400", description = "The requested product was not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.findById(id));
    }

    @Operation(summary = "Gets a list of products by category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product list successfully returned"),
    })
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(productService.filterByCategory(category));
    }

    @Operation(summary = "Gets a list of products by city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product list successfully returned"),
    })

    @GetMapping("/city/{city_name}")
    public ResponseEntity<List<Product>> getProductsByCity(@PathVariable String city_name) {
        return ResponseEntity.ok(productService.filterByCity(city_name));
    }

    //

    /* POST FUNCTIONS */
    @Operation(summary = "Adds a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully added"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content),
            @ApiResponse(responseCode = "400", description = "Product already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity addProduct(@RequestBody Product product) throws CreatingExistingEntityException, EmptyFieldException, ResourceNotFoundException{
    return ResponseEntity.ok(productService.create(product));
    }

    /* EDIT FUNCTIONS */
    @Operation(summary = "Edits a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully updated"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    @PutMapping("/edit")
    public ResponseEntity editProduct(@RequestBody Product product) throws EmptyFieldException {
        return ResponseEntity.ok(productService.edit(product));
    }

    /* DELETE FUNCTIONS */
    @Operation(summary = "Deletes a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body",content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    @DeleteMapping
    public ResponseEntity<Product> deleteProduct(@RequestBody Product product) throws EmptyFieldException {
        return ResponseEntity.ok(productService.delete(product));
    }

    @Operation(summary = "Deletes a product by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request URL", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product Id not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.deleteById(id));
    }


}
