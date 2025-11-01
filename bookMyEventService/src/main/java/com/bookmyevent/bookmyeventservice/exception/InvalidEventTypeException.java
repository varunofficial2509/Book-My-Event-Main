package com.bookmyevent.bookmyeventservice.exception;

public class InvalidEventTypeException extends RuntimeException {
    public InvalidEventTypeException(String message) {
        super(message);
    }
}
