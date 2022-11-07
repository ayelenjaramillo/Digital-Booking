package com.dh.CrudCategorias.controllers;

import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.*;
import com.dh.CrudCategorias.services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ciudades")
public class CiudadController {
    @Autowired
    CiudadService ciudadService;

    @PostMapping("/crear_ciudad") //(@RequestBody ProductoDTO productoDTO, @PathVariable Integer id,CategoriaDTO categoriaDTO, Ciudad ciudadDTO)
    public ResponseEntity<Ciudad> crearCiudad(@RequestBody CiudadDTO ciudadDTO){
        return  ResponseEntity.ok(ciudadService.agregarCiudad(ciudadDTO));
    }

    @GetMapping("/{id}")
    public Ciudad buscarCiudadPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        return  ciudadService.buscarCiudadPorId(id);
    }


}
