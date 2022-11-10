package com.dh.CrudCategorias.controllers;
import com.dh.CrudCategorias.models.Image;
import com.dh.CrudCategorias.models.ImageDTO;
import com.dh.CrudCategorias.services.ImageService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;

public class ImageController {

    @Autowired
    ImageService imagenService;

    @PostMapping("/agregar_imagen")
    public ResponseEntity<Image> agregarImagen (@RequestBody ImageDTO imageDTO){
        return  ResponseEntity.ok(imagenService.agregarImagen(imageDTO));
    }



}
