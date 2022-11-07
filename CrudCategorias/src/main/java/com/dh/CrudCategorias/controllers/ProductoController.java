package com.dh.CrudCategorias.controllers;
import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.*;
import com.dh.CrudCategorias.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    // GET
    @GetMapping("/{id}")
    public Producto buscarProductoPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        return  productoService.buscarProductoPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){return ResponseEntity.ok(productoService.listarProductos());}


    @GetMapping("/city/{city}")
    public ResponseEntity<List<Producto>> getProductsByCity(@PathVariable String ciudad) {
        return ResponseEntity.ok(productoService.buscarPorCiudad(ciudad));
    }

    @GetMapping("/categoria/{titulo}")
    public ResponseEntity<List<Producto>> buscar(@PathVariable String titulo) {
        return ResponseEntity.ok(productoService.buscarPorCiudad(titulo));
    }


    // POST
    @PostMapping("/crear") //(@RequestBody ProductoDTO productoDTO, @PathVariable Integer id,CategoriaDTO categoriaDTO, Ciudad ciudadDTO)
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDTO productoDTO){
        return  ResponseEntity.ok(productoService.agregarProducto(productoDTO));
    }

/*   @PostMapping("/agregarCategoria/{id}") //(@RequestBody ProductoDTO productoDTO, @PathVariable Integer id,CategoriaDTO categoriaDTO, Ciudad ciudadDTO)
    public ResponseEntity<Producto> agregarCategoria(@RequestBody ProductoDTO productoDTO, @PathVariable Integer id){
        return  ResponseEntity.ok(productoService.agregarProducto(productoDTO, Integer id));
    }*/

    //no aparece aun en historia
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto (@RequestBody ProductoDTO productoDTO, @PathVariable Integer id) throws ResourceNotFoundException {
        Producto producto = productoService.actualizarProducto(productoDTO, id);
        return  ResponseEntity.ok(producto);
    }

    //no aparece aun en historia
   /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) throws ResourceNotFoundException{
        productoService.eliminarProducto(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    } */

    /*@GetMapping("productos/ciudad/{id}")//????
    public Producto buscarProductoPorCiudad(@PathVariable Integer idCiudad) throws ResourceNotFoundException {
        listarProductos();
        return  productoService.buscarProductoPorIdDeCiudad(idCiudad);
    }*/


}
