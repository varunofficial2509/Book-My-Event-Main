package com.bookmyevent.bookmyeventservice.exception;

public class InsufficientTicketsException extends RuntimeException {
    public InsufficientTicketsException(String message) {
        super(message);
    }
}
