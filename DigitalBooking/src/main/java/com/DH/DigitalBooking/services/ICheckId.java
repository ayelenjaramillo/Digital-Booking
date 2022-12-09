package com.DH.DigitalBooking.services;

import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;



public interface ICheckId<T>{
    //String messageError = "No se encontraron resultados con id: ";
    T checkId(Long a) throws ResourceNotFoundException;
}
