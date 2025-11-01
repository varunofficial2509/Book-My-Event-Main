package com.bookmyevent.bookmyeventservice.model;

public enum BookingStatus {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled"),
    REFUNDED("Refunded"),
    FAILED("Failed");

    private final String displayName;

    BookingStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
