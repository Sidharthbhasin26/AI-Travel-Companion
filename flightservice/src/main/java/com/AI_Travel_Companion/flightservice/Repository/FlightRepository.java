package com.AI_Travel_Companion.flightservice.Repository;

import com.AI_Travel_Companion.flightservice.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight , Long> {

    List<Flight> findByDepartureAirportAndArrivalAirport(String departureAirport , String arrivalAirport);

}
