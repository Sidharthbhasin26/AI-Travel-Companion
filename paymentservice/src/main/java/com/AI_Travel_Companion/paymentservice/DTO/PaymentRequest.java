package com.AI_Travel_Companion.paymentservice.DTO;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentRequest {
    private Long bookingId;
    private double amount;
}
