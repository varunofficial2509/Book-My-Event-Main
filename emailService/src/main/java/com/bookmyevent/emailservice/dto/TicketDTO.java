package com.bookmyevent.emailservice.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TicketDTO implements Serializable {
    private Long id;
    private String ticketNumber;
    private String ticketCategoryName;
    private String seatNumber;        // Null for outdoor events
    private BigDecimal price;

    public TicketDTO() {}

    public TicketDTO(Long id, String ticketNumber, String ticketCategoryName,
                     String seatNumber, BigDecimal price) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.ticketCategoryName = ticketCategoryName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketCategoryName() {
        return ticketCategoryName;
    }

    public void setTicketCategoryName(String ticketCategoryName) {
        this.ticketCategoryName = ticketCategoryName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}