package com.AI_Travel_Companion.bookingservice.Service;


import com.AI_Travel_Companion.bookingservice.Clients.FlightOpenFeignClient;
import com.AI_Travel_Companion.bookingservice.DTO.BookingRequest;
import com.AI_Travel_Companion.bookingservice.DTO.BookingResponse;
import com.AI_Travel_Companion.bookingservice.DTO.FlightResponse;
import com.AI_Travel_Companion.bookingservice.Entity.BookingEntity;
import com.AI_Travel_Companion.bookingservice.Repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final FlightOpenFeignClient flightOpenFeignClient;
    private final BookingRepository bookingRepository;



    public BookingResponse createBooking(BookingRequest bookingRequest) {
        FlightResponse flight = flightOpenFeignClient.flightById(bookingRequest.getFlightId());

        if (flight.getAvailableSeats() < bookingRequest.getSeat()){
            throw new RuntimeException("Seats are not available ");
        }

        BookingEntity bookingEntity = new BookingEntity();

    }
}
