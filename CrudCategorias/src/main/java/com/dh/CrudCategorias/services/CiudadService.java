package com.dh.CrudCategorias.services;
import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.Categoria;
import com.dh.CrudCategorias.models.Ciudad;
import com.dh.CrudCategorias.models.CiudadDTO;
import com.dh.CrudCategorias.repositories.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class CiudadService {

    @Autowired
    CiudadRepository ciudadRepository;

    public Ciudad agregarCiudad(CiudadDTO ciudadDTO) {
        Ciudad ciudad = new Ciudad(ciudadDTO);
        return ciudadRepository.save(ciudad);
    }

    public Ciudad buscarCiudadPorId(Integer id) throws ResourceNotFoundException {
        Ciudad ciudad = ciudadRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontró la ciudad con el id" + id));
        return ciudad;
    }



}
