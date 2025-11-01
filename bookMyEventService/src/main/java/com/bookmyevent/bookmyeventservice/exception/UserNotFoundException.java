package com.bookmyevent.bookmyeventservice.exception;

public class UserNotFoundException extends BookingFailedException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
