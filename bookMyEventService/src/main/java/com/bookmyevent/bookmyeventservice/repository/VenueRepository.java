package com.bookmyevent.bookmyeventservice.repository;

import com.bookmyevent.bookmyeventservice.entity.City;
import com.bookmyevent.bookmyeventservice.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

    @Query("SELECT v FROM Venue v WHERE v.city.cityName = :cityName")
    List<Venue> findByCityName(@Param("cityName") String cityName);

    // Also useful
    List<Venue> findByCity(City city);
    List<Venue> findByCityId(Long cityId);
}
