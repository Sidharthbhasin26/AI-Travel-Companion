package com.AI_Travel_Companion.flightservice.Config;

import com.AI_Travel_Companion.flightservice.Entity.Flight;
import com.AI_Travel_Companion.flightservice.Entity.flightStatus;
import com.AI_Travel_Companion.flightservice.Repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@RequiredArgsConstructor
public class FlightDataSeeder implements CommandLineRunner {

    private final FlightRepository flightRepository;
    @Override
    public void run(String... args) throws Exception {

        if (flightRepository.count() > 0) {
            return;
        }

        Flight f1 = Flight.builder()
                .flightNumber("AI-201")
                .airline("Air India")
                .departureAirport("DEL")
                .arrivalAirport("GOA")
                .departureTime(LocalDateTime.of(2026, 10, 1, 8, 0))
                .arrivalTime(LocalDateTime.of(2026, 10, 1, 10, 30))
                .availableSeats(120)
                .fare(5500.0)
                .status(flightStatus.ON_TIME)
                .build();

        Flight f2 = Flight.builder()
                .flightNumber("6E-302")
                .airline("IndiGo")
                .departureAirport("DEL")
                .arrivalAirport("GOA")
                .departureTime(LocalDateTime.of(2026, 10, 1, 14, 0))
                .arrivalTime(LocalDateTime.of(2026, 10, 1, 16, 30))
                .availableSeats(80)
                .fare(4800.0)
                .status(flightStatus.ON_TIME)
                .build();

        // DEL -> BOM
        Flight f3 = Flight.builder()
                .flightNumber("UK-501")
                .airline("Vistara")
                .departureAirport("DEL")
                .arrivalAirport("BOM")
                .departureTime(LocalDateTime.of(2026, 10, 2, 9, 0))
                .arrivalTime(LocalDateTime.of(2026, 10, 2, 11, 15))
                .availableSeats(100)
                .fare(6200.0)
                .status(flightStatus.ON_TIME)
                .build();

        // BLR -> DEL
        Flight f4 = Flight.builder()
                .flightNumber("6E-707")
                .airline("IndiGo")
                .departureAirport("BLR")
                .arrivalAirport("DEL")
                .departureTime(LocalDateTime.of(2026, 10, 3, 18, 0))
                .arrivalTime(LocalDateTime.of(2026, 10, 3, 20, 45))
                .availableSeats(90)
                .fare(5900.0)
                .status(flightStatus.DELAYED)
                .build();

        // Sab save karo
        flightRepository.save(f1);
        flightRepository.save(f2);
        flightRepository.save(f3);
        flightRepository.save(f4);




    }
}
