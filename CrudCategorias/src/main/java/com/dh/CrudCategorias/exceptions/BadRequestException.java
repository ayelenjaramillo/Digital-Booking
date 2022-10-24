package com.dh.CrudCategorias.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends ResponseStatusException {
    public BadRequestException(String mensaje){
        super(HttpStatus.BAD_REQUEST, mensaje);
    }
}
