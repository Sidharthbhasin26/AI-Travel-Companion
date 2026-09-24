package com.AI_Travel_Companion.bookingservice.Service;


import com.AI_Travel_Companion.bookingservice.Clients.FlightOpenFeignClient;
import com.AI_Travel_Companion.bookingservice.DTO.BookingRequest;
import com.AI_Travel_Companion.bookingservice.DTO.BookingResponse;
import com.AI_Travel_Companion.bookingservice.DTO.FlightResponse;
import com.AI_Travel_Companion.bookingservice.Entity.BookingEntity;
import com.AI_Travel_Companion.bookingservice.Entity.BookingStatus;
import com.AI_Travel_Companion.bookingservice.Repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final FlightOpenFeignClient flightOpenFeignClient;
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;



    public BookingResponse createBooking(BookingRequest bookingRequest) {
        FlightResponse flight = flightOpenFeignClient.flightById(bookingRequest.getFlightId());

        if (flight.getAvailableSeats() < bookingRequest.getSeat()){
            throw new RuntimeException("Seats are not available ");
        }

        double amount = flight.getFare() * bookingRequest.getSeat();

        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setFlightId(bookingRequest.getFlightId());
        bookingEntity.setSeat(bookingRequest.getSeat());
        bookingEntity.setUserId(bookingRequest.getUserId());
        bookingEntity.setAmount(amount);
        bookingEntity.setStatus(BookingStatus.PENDING);

       BookingEntity saved = bookingRepository.save(bookingEntity);


      return modelMapper.map(saved , BookingResponse.class);


    }
}
