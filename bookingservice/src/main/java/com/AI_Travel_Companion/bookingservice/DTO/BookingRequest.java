package com.AI_Travel_Companion.bookingservice.DTO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingRequest {
    private Long flightId;

    private int seat;

    private Long userId;
}
