package com.dh.CrudCategorias.controllers;
import com.dh.CrudCategorias.models.Imagen;
import com.dh.CrudCategorias.models.ImagenDTO;
import com.dh.CrudCategorias.services.ImagenService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;

public class ImagenController {

    @Autowired
    ImagenService imagenService;

    @PostMapping("/agregar_imagen")
    public ResponseEntity<Imagen> agregarImagen (@RequestBody ImagenDTO imagenDTO){
        return  ResponseEntity.ok(imagenService.agregarImagen(imagenDTO));
    }



}
