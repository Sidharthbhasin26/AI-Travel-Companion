package com.AI_Travel_Companion.flightservice.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


