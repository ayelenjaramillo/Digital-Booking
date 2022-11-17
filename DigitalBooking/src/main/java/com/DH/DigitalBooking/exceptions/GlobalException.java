package com.DH.DigitalBooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler({com.DH.DigitalBooking.exceptions.BadRequestException.class})
    public ResponseEntity<String> procesarBadRequest(com.DH.DigitalBooking.exceptions.BadRequestException exception){
        return new ResponseEntity<String>(exception.getMessage(),exception.getStatus());
    }
    @ExceptionHandler({com.DH.DigitalBooking.exceptions.ResourceNotFoundException.class})
    public  ResponseEntity<String> procesarErrorNotFound(com.DH.DigitalBooking.exceptions.ResourceNotFoundException ex){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


}
