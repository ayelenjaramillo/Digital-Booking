package com.DH.DigitalBooking.exceptions;

public class CreatingExistingEntityException extends Exception{
    public CreatingExistingEntityException() {
    }
    public CreatingExistingEntityException(String msg) {
        super(msg);
    }
}
