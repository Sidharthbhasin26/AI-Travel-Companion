package com.AI_Travel_Companion.bookingservice.Controller;

import com.AI_Travel_Companion.bookingservice.DTO.BookingRequest;
import com.AI_Travel_Companion.bookingservice.DTO.BookingResponse;
import com.AI_Travel_Companion.bookingservice.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest bookingRequest){
        BookingResponse saved = bookingService.createBooking(bookingRequest);
        return new ResponseEntity<>(saved , HttpStatus.ACCEPTED);
    }
}
