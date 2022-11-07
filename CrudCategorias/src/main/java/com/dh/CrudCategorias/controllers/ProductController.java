package com.dh.CrudCategorias.controllers;
import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.*;
import com.dh.CrudCategorias.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    ProductService productService;

    // GET
    @GetMapping("/{id}")
    public Product buscarProductoPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        return  productService.buscarProductoPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listarProductos(){return ResponseEntity.ok(productService.listarProductos());}


    @GetMapping("/city/{city}")
    public ResponseEntity<List<Product>> getProductsByCity(@PathVariable String ciudad) {
        return ResponseEntity.ok(productService.buscarPorCiudad(ciudad));
    }

    @GetMapping("/categoria/{titulo}")
    public ResponseEntity<List<Product>> buscar(@PathVariable String titulo) {
        return ResponseEntity.ok(productService.buscarPorCiudad(titulo));
    }


    // POST
    @PostMapping("/crear") //(@RequestBody ProductoDTO productoDTO, @PathVariable Integer id,CategoriaDTO categoriaDTO, Ciudad ciudadDTO)
    public ResponseEntity<Product> crearProducto(@RequestBody ProductDTO productDTO){
        return  ResponseEntity.ok(productService.agregarProducto(productDTO));
    }

/*   @PostMapping("/agregarCategoria/{id}") //(@RequestBody ProductoDTO productoDTO, @PathVariable Integer id,CategoriaDTO categoriaDTO, Ciudad ciudadDTO)
    public ResponseEntity<Producto> agregarCategoria(@RequestBody ProductoDTO productoDTO, @PathVariable Integer id){
        return  ResponseEntity.ok(productoService.agregarProducto(productoDTO, Integer id));
    }*/

    //no aparece aun en historia
    @PutMapping("/{id}")
    public ResponseEntity<Product> actualizarProducto (@RequestBody ProductDTO productDTO, @PathVariable Integer id) throws ResourceNotFoundException {
        Product product = productService.actualizarProducto(productDTO, id);
        return  ResponseEntity.ok(product);
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
