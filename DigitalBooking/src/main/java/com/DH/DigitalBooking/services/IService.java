package com.DH.DigitalBooking.services;

import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IService<T> {
    public List<T> listAll();
    public T findById(Long id) throws ResourceNotFoundException;
    public T create(T t) throws EmptyFieldException, CreatingExistingEntityException, ResourceNotFoundException;
    public T edit(T t) throws ResourceNotFoundException, EmptyFieldException;
    public T delete(T t) throws ResourceNotFoundException, EmptyFieldException;
    public T deleteById(Long id) throws ResourceNotFoundException;
}