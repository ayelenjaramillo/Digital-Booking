package com.dh.CrudCategorias.exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
