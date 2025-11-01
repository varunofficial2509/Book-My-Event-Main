package com.bookmyevent.emailservice.util;

public class EmailServiceConstants {

    public static final String emailFormat = """
                    🎉 Booking Confirmed! 🎉
    
                    Dear %s,
    
                    Your booking for "%s" at %s, %s is confirmed!
    
                    📅 Date: %s
                    🕐 Time: %s
                    🎫 %s
                    
                    Booking Reference: %s
    
                    Enjoy the event!
    
                    ---
    
                    Thank you for choosing BookMyEvent.
                    For any queries, please quote your booking reference.
                    """;

    public static final String emailSubject = "🎬 Booking Confirmation - BookMyEvent";
}