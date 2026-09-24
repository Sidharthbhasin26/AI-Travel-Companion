package com.AI_Travel_Companion.paymentservice.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;

    private double money;

    private String currency;

    private String stripePaymentIntentId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;



}
