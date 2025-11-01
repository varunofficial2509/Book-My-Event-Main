package com.bookmyevent.bookmyeventservice.repository;

import com.bookmyevent.bookmyeventservice.entity.Booking;
import com.bookmyevent.bookmyeventservice.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.user.id = :userId ORDER BY b.bookingDate DESC")
    List<Booking> findByUserId(@Param("userId") Long userId);

    @Query("SELECT b FROM Booking b WHERE b.event.id = :eventId")
    List<Booking> findByEventId(@Param("eventId") Long eventId);

    @Query("SELECT b FROM Booking b WHERE b.bookingReference = :reference")
    Optional<Booking> findByBookingReference(@Param("reference") String reference);

    @Query("SELECT b FROM Booking b WHERE b.user.id = :userId AND b.status = :status")
    List<Booking> findByUserIdAndStatus(@Param("userId") Long userId, @Param("status") BookingStatus status);
}
