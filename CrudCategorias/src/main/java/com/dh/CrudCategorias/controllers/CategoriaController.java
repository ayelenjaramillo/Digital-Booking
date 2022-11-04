package com.dh.CrudCategorias.controllers;

import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.Categoria;
import com.dh.CrudCategorias.models.CategoriaDTO;
import com.dh.CrudCategorias.models.ProductoDTO;
import com.dh.CrudCategorias.services.CategoriaService;
import com.dh.CrudCategorias.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;
    //DIAPO 41
    /*Como usuario quiero poder filtrar por una categoría para ver solo los productos de la categoría que me interesa.
    Las categorías que se ven en el home deben obtenerse de la base de datos.
    Listar productos según categoría y dónde?
    Al clickear en una categoría, se deben obtener de la base de datos y mostrar los productos de esa categoría.*/

    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody CategoriaDTO categoriaDTO){
        return  ResponseEntity.ok(categoriaService.agregarCategoria(categoriaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria (@RequestBody CategoriaDTO categoriaDTO, @PathVariable Integer id) throws ResourceNotFoundException{
        Categoria categoria = categoriaService.actualizarCategoria(categoriaDTO, id);
        return  ResponseEntity.ok(categoria);
    }

    @GetMapping("/{id}")
    public Categoria buscarCategoriaPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        return  categoriaService.buscarCategoriaPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Integer id) throws ResourceNotFoundException{
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public List<Categoria> listarCategorias(){
        return categoriaService.listarCategorias();
    }



}
