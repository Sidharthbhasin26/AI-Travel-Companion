package com.AI_Travel_Companion.paymentservice.Service;


import com.AI_Travel_Companion.paymentservice.DTO.PaymentRequest;
import com.AI_Travel_Companion.paymentservice.DTO.PaymentResponse;
import com.AI_Travel_Companion.paymentservice.Entity.PaymentEntity;
import com.AI_Travel_Companion.paymentservice.Entity.PaymentStatus;
import com.AI_Travel_Companion.paymentservice.Repository.PaymentRepository;
import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    @Value("${stripe.secret-key}")
    private String stripeSecretKey;

    public PaymentResponse createPayment(PaymentRequest paymentRequest) {

        Stripe.apiKey = stripeSecretKey;

        try{
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount((long) (paymentRequest.getAmount() * 100))
                    .setCurrency("inr")
                    .putMetadata("bookingId", paymentRequest.getBookingId().toString())
                    .build();

            PaymentIntent intent = PaymentIntent.create(params);

            PaymentEntity paymentEntity = new PaymentEntity();
            paymentEntity.setBookingId(paymentRequest.getBookingId());
            paymentEntity.setAmount(paymentRequest.getAmount());
            paymentEntity.setCurrency("inr");
            paymentEntity.setStripePaymentIntentId(intent.getId());
            paymentEntity.setPaymentStatus(PaymentStatus.CREATED);

            paymentRepository.save(paymentEntity);

            return new PaymentResponse(intent.getClientSecret());


        } catch (Exception e) {
            throw new RuntimeException("Payment creation failed: " + e.getMessage());
        }

    }

}
