package com.bookmyevent.bookmyeventservice.exception;

public class TicketCategoryNotFoundException extends RuntimeException {
    public TicketCategoryNotFoundException(String message) {
        super(message);
    }
}
