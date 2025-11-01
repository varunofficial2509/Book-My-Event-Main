package com.bookmyevent.emailservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Data
public class BookingDTO implements Serializable {
    private Long bookingId;
    private String bookingReferenceId;
    private String userEmail;
    private String userName;
    private String eventName;
    private String venueName;
    private String cityName;
    private List<TicketDTO> tickets;
    private List<String> seatNumbers;
    private LocalDateTime bookingTime;
    private LocalDateTime showTime;

    // Default constructor
    public BookingDTO() {
    }

    // All-args constructor
    public BookingDTO(Long bookingId, String bookingReferenceId, String userEmail,
                      String userName, String eventName, String venueName, String cityName,
                      List<String> seatNumbers, LocalDateTime bookingTime, LocalDateTime showTime, List<TicketDTO> tickets) {
        this.bookingId = bookingId;
        this.bookingReferenceId = bookingReferenceId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.eventName = eventName;
        this.venueName = venueName;
        this.cityName = cityName;
        this.seatNumbers = seatNumbers;
        this.bookingTime = bookingTime;
        this.showTime = showTime;
        this.tickets = tickets;
    }

    public List<com.bookmyevent.emailservice.dto.TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingReferenceId() {
        return bookingReferenceId;
    }

    public void setBookingReferenceId(String bookingReferenceId) {
        this.bookingReferenceId = bookingReferenceId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
