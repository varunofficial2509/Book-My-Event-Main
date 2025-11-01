package com.bookmyevent.bookmyeventservice.repository;

import com.bookmyevent.bookmyeventservice.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.booking.id = :bookingId")
    List<Ticket> findByBookingId(@Param("bookingId") Long bookingId);

    @Query("SELECT t FROM Ticket t WHERE t.ticketNumber = :ticketNumber")
    Optional<Ticket> findByTicketNumber(@Param("ticketNumber") String ticketNumber);
}
