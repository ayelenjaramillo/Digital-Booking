package com.dh.CrudCategorias.services;

import com.dh.CrudCategorias.models.Ciudad;
import com.dh.CrudCategorias.models.CiudadDTO;
import com.dh.CrudCategorias.models.Imagen;
import com.dh.CrudCategorias.models.ImagenDTO;
import com.dh.CrudCategorias.repositories.ImagenRepository;
import com.dh.CrudCategorias.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenService {
    @Autowired
    ImagenRepository imagenRepository;

    public Imagen agregarImagen(ImagenDTO imagenDTO) {
        Imagen imagen = new Imagen(imagenDTO);
        return imagenRepository.save(imagen);
    }

}
