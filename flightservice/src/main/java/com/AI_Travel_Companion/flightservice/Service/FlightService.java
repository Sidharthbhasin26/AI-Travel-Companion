package com.AI_Travel_Companion.flightservice.Service;

import com.AI_Travel_Companion.flightservice.DTO.FlightRequest;
import com.AI_Travel_Companion.flightservice.DTO.FlightResponse;
import com.AI_Travel_Companion.flightservice.Entity.Flight;
import com.AI_Travel_Companion.flightservice.Entity.flightStatus;
import com.AI_Travel_Companion.flightservice.Exception.FlightNotFoundException;
import com.AI_Travel_Companion.flightservice.Repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    public List<FlightResponse> getFlights(String departureAirport, String arrivalAirport) {

        List<Flight> flights = flightRepository.findByDepartureAirportAndArrivalAirport(departureAirport , arrivalAirport);


        return flights.stream()
                .map(flight -> modelMapper.map(flight , FlightResponse.class))
                .toList();




    }

    public FlightResponse addFlights(FlightRequest flightRequest) {
        Flight flights = new Flight();

        flights.setFlightNumber(flightRequest.getFlightNumber());
        flights.setAirline(flightRequest.getAirline());
        flights.setDepartureAirport(flightRequest.getDepartureAirport());
        flights.setArrivalAirport(flightRequest.getArrivalAirport());
        flights.setDepartureTime(flightRequest.getDepartureTime());
        flights.setArrivalTime(flightRequest.getArrivalTime());
        flights.setAvailableSeats(flightRequest.getAvailableSeats());
        flights.setFare(flightRequest.getFare());
        flights.setStatus(flightStatus.ON_TIME);




       Flight savedFlights = flightRepository.save(flights);
       return modelMapper.map(savedFlights , FlightResponse.class);



    }

    public FlightResponse flightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight with id " + id + " not found"));
        return modelMapper.map(flight , FlightResponse.class);
    }
}
