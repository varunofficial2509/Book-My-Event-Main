package com.bookmyevent.bookmyeventservice.exception;

public class ConcurrentBookingException extends RuntimeException {
    public ConcurrentBookingException(String message) {
        super(message);
    }
}
