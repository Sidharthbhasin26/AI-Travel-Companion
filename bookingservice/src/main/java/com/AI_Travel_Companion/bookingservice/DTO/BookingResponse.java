package com.AI_Travel_Companion.bookingservice.DTO;


import com.AI_Travel_Companion.bookingservice.Entity.BookingStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponse {
    private Long id;
    private Long userId;
    private Long flightId;

    private int seat;
    private double amount;

    private BookingStatus bookingStatus;

    private LocalDateTime createdAt;
}
