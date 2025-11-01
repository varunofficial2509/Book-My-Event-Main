package com.bookmyevent.bookmyeventservice.model;

public enum EventStatus {
    UPCOMING("Upcoming"),
    ONGOING("Ongoing"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled"),
    POSTPONED("Postponed");

    private final String displayName;

    EventStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}