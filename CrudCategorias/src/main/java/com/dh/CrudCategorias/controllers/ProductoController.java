package com.dh.CrudCategorias.controllers;

import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.Categoria;
import com.dh.CrudCategorias.models.CategoriaDTO;
import com.dh.CrudCategorias.models.Producto;
import com.dh.CrudCategorias.models.ProductoDTO;
import com.dh.CrudCategorias.services.CategoriaService;
import com.dh.CrudCategorias.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDTO productoDTO){
        return  ResponseEntity.ok(productoService.agregarProducto(productoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarCategoria (@RequestBody ProductoDTO productoDTO, @PathVariable Integer id) throws ResourceNotFoundException {
        Producto producto = productoService.actualizarProducto(productoDTO, id);
        return  ResponseEntity.ok(producto);
    }

    @GetMapping("/{id}")
    public Producto buscarProductoPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        return  productoService.buscarProductoPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) throws ResourceNotFoundException{
        productoService.eliminarProducto(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public List<Producto> listarProductos(){
        return productoService.listarProductos();
    }



}
