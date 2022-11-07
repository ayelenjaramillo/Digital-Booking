package com.dh.CrudCategorias.controllers;
import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.Category;
import com.dh.CrudCategorias.models.CategoryDTO;
import com.dh.CrudCategorias.services.CategoryService;
import com.dh.CrudCategorias.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //VER
    @Autowired
    ProductService productService;

    //DIAPO 41
    /*Como usuario quiero poder filtrar por una categoría para ver solo los productos de la categoría que me interesa.
    Las categorías que se ven en el home deben obtenerse de la base de datos.
    Listar productos según categoría y dónde?
    Al clickear en una categoría, se deben obtener de la base de datos y mostrar los productos de esa categoría.*/


    @GetMapping("/{id}")
    public Category buscarCategoriaPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        return  categoryService.buscarCategoriaPorId(id);
    }


    @PostMapping
    public ResponseEntity<Category> crearCategoria(@RequestBody CategoryDTO categoryDTO){
        return  ResponseEntity.ok(categoryService.agregarCategoria(categoryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> actualizarCategoria (@RequestBody CategoryDTO categoryDTO, @PathVariable Integer id) throws ResourceNotFoundException{
        Category category = categoryService.actualizarCategoria(categoryDTO, id);
        return  ResponseEntity.ok(category);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Integer id) throws ResourceNotFoundException{
        categoryService.eliminarCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public List<Category> listarCategorias(){
        return categoryService.listarCategorias();
    }



}
