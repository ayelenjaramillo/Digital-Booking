package com.dh.CrudCategorias.services;
import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.City;
import com.dh.CrudCategorias.models.CityDTO;
import com.dh.CrudCategorias.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public City agregarCiudad(CityDTO ciudadDTO) {
        City city = new City(ciudadDTO);
        return cityRepository.save(city);
    }

    public City buscarCiudadPorId(Integer id) throws ResourceNotFoundException {
        City city = cityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontró la ciudad con el id" + id));
        return city;
    }



}
