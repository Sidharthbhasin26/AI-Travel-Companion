package com.AI_Travel_Companion.bookingservice.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightResponse {
    private Long id;

    private String flightNumber;

    private String airline;

    private String departureAirport;
    private String arrivalAirport;


    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    private int availableSeats;

    private double fare;


    private String status;
}
