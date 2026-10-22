package com.AI_Travel_Companion.paymentservice.Event;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSucceededEvent {
    private Long bookingId;
}
