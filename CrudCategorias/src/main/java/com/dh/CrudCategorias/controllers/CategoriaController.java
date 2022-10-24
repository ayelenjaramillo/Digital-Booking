package com.dh.CrudCategorias.controllers;

import com.dh.CrudCategorias.models.Categoria;
import com.dh.CrudCategorias.models.CategoriaDTO;
import com.dh.CrudCategorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;


    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        return  ResponseEntity.ok(categoriaService.agregarCategoria(categoria));
    }

    @PutMapping
    public ResponseEntity<?> actualizarCategoria (@RequestBody Categoria categoria){
        categoriaService.actualizarCategoria(categoria);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public CategoriaDTO buscarCategoriaPorId(@PathVariable Integer id){
        return  categoriaService.buscarCategoriaPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Integer id){
        ResponseEntity<String> respuesta = null;
        categoriaService.eliminarCategoria(id);
        respuesta = ResponseEntity.status(HttpStatus.OK).body("Eliminado correctamente");
        return respuesta;
    }

    @GetMapping
    public Collection<CategoriaDTO> listarCategorias(){
        return categoriaService.listarCategorias();
    }
}
