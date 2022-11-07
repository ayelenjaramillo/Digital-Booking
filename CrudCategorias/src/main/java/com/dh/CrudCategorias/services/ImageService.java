package com.dh.CrudCategorias.services;

import com.dh.CrudCategorias.models.Image;
import com.dh.CrudCategorias.models.ImageDTO;
import com.dh.CrudCategorias.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageRepository imagenRepository;

    public Image agregarImagen(ImageDTO imagenDTO) {
        Image image = new Image(imagenDTO);
        return imagenRepository.save(image);
    }

}
