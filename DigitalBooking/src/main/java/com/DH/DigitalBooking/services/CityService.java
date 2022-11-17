package com.DH.DigitalBooking.services;
import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.City;
import com.DH.DigitalBooking.models.Product;
import com.DH.DigitalBooking.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;


    public List<City> listAll() {
        return cityRepository.findAll();
    }

    public City findById(Long id) throws ResourceNotFoundException {
        if(id == null){
            throw new ResourceNotFoundException("No ID received");
        }
        Optional<City> result = cityRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new ResourceNotFoundException("Specified city could not be found.");
        }
    }

    public City create(City location) throws EmptyFieldException, CreatingExistingEntityException, ResourceNotFoundException {
        if(location.getId() != null){
            throw new CreatingExistingEntityException("City' IDs are auto-generated, you cannot specify it");
        }
        return cityRepository.save(location);
    }

    public City edit(City city) throws ResourceNotFoundException, EmptyFieldException {
        if(city.getId() == null){
            throw new EmptyFieldException("City must have an id to edit");
        }
        findById(city.getId());
        return cityRepository.save(city);
    }

    public City delete(City location) throws ResourceNotFoundException, EmptyFieldException {
        if(location.getId() == null){
            throw new EmptyFieldException("City must have an id to delete");
        }
        cityRepository.delete(location);
        return location;
    }

    public City deleteById(Long id) throws ResourceNotFoundException {
        List<Product> productos = cityRepository.findAllByCityId(id);
        if(productos.size() != 0){
//            MODIFICAR CREANDO NUEVA EXCEPTION
            throw new ResourceNotFoundException("Cannot delete cities with associated products");
        }
        City result = findById(id);
        cityRepository.delete(result);
        return result;
    }
}
