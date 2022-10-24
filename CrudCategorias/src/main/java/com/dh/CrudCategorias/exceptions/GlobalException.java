package com.dh.CrudCategorias.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarBadRequest(BadRequestException exception){
        return new ResponseEntity<String>(exception.getMessage(),exception.getStatus());
    }
    @ExceptionHandler({ResourceNotFoundException.class})
    public  ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException ex){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
