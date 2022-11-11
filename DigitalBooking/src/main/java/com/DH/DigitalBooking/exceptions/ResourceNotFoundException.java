package com.DH.DigitalBooking.exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
