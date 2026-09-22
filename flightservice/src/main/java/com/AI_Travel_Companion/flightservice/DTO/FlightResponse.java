package com.AI_Travel_Companion.flightservice.DTO;

import com.AI_Travel_Companion.flightservice.Entity.flightStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    @Enumerated(EnumType.STRING)
    private flightStatus status;
}
