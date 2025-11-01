package com.bookmyevent.bookmyeventservice.repository;

import com.bookmyevent.bookmyeventservice.entity.TicketCategory;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT tc FROM TicketCategory tc WHERE tc.id IN :categoryIds")
    List<TicketCategory> findByIdInWithLock(@Param("categoryIds") List<Long> categoryIds);

    @Query("SELECT tc FROM TicketCategory tc WHERE tc.event.id = :eventId")
    List<TicketCategory> findByEventId(@Param("eventId") Long eventId);

    @Query("SELECT tc FROM TicketCategory tc WHERE tc.event.id = :eventId AND tc.availableQuantity > 0")
    List<TicketCategory> findAvailableByEventId(@Param("eventId") Long eventId);
}
