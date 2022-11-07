package com.dh.CrudCategorias.controllers;

import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.*;
import com.dh.CrudCategorias.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ciudades")
public class CityController {
    @Autowired
    CityService cityService;

    @PostMapping("/crear_ciudad") //(@RequestBody ProductoDTO productoDTO, @PathVariable Integer id,CategoriaDTO categoriaDTO, Ciudad ciudadDTO)
    public ResponseEntity<City> crearCiudad(@RequestBody CityDTO cityDTO){
        return  ResponseEntity.ok(cityService.agregarCiudad(cityDTO));
    }

    @GetMapping("/{id}")
    public City buscarCiudadPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        return  cityService.buscarCiudadPorId(id);
    }


}
