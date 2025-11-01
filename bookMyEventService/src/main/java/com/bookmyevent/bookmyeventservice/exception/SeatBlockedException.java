package com.bookmyevent.bookmyeventservice.exception;

public class SeatBlockedException extends BookingFailedException {
    public SeatBlockedException(String message) {
        super(message);
    }
}
