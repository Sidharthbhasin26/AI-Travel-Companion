package com.AI_Travel_Companion.bookingservice.Event;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSucceededEvent {
    private Long bookingId;
}
