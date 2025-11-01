package com.bookmyevent.bookmyeventservice.exception;

public class SeatAlreadyBookedException extends BookingFailedException {
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}
