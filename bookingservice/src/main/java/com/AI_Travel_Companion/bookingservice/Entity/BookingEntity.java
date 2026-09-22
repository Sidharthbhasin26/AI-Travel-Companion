package com.AI_Travel_Companion.bookingservice.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingEntity {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long flightId;

    private int seat;

    private double amount;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
