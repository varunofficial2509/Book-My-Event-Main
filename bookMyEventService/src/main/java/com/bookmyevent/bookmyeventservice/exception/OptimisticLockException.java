package com.bookmyevent.bookmyeventservice.exception;

public class OptimisticLockException extends RuntimeException {
    public OptimisticLockException(String message) {
        super(message);
    }
}
