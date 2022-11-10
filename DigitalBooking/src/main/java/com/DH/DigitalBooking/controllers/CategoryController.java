package com.DH.DigitalBooking.controllers;

import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.Category;
import com.DH.DigitalBooking.repositories.CategoryRepository;
import com.DH.DigitalBooking.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;


    //listCategories()
    //addCategory
    //editCategory
    //deleteCategory


    @CrossOrigin(origins = "*")
    @Operation(summary = "Returns a list of categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    @GetMapping
    public ResponseEntity<List<Category>> listAllCategories() throws ResourceNotFoundException {
        return ResponseEntity.ok(categoryService.listAllCategories()) ;
    }

    @Operation(summary = "Adds a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category successfully added"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content)
    })
    @PostMapping
    //public ResponseEntity addCategory(@RequestBody @Valid Category category)
    public ResponseEntity addCategory(@RequestBody  Category category) throws EmptyFieldException,CreatingExistingEntityException {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    /*@PostMapping
    public ResponseEntity addCategory(@RequestBody Category category) throws CreatingExistingEntityException, EmptyFieldException, ResourceNotFoundException {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }*/

    @Operation(summary = "Edits a category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category successfully updated"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content)
    })
    @PutMapping
    public ResponseEntity editCategory(@RequestBody Category category) throws ResourceNotFoundException, EmptyFieldException {
        Category result = categoryService.edit(category);
        return ResponseEntity.ok(result);
    }

   @Operation(summary = "Deletes a category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request body",content = @Content)
    })
    @DeleteMapping
    public ResponseEntity<Category> deleteCategory(@RequestBody Category category) throws ResourceNotFoundException, EmptyFieldException {
        Category result = categoryService.delete(category);
        return ResponseEntity.ok(result);
    }


    @Operation(summary = "Deletes a category by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Incorrectly formatted request URL", content = @Content),
            @ApiResponse(responseCode = "404", description = "Category Id not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) throws ResourceNotFoundException {
        Category result = categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(result);
    }
}




