package com.DH.DigitalBooking.exceptions;

public class EmptyFieldException extends Exception{
    public EmptyFieldException() {
    }

    public EmptyFieldException(String msg) {
        super(msg);
    }
}


