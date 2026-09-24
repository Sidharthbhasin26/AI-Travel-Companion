package com.AI_Travel_Companion.paymentservice.Repository;

import com.AI_Travel_Companion.paymentservice.Entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity , Long> {

    PaymentEntity findByStripePaymentIntentId(String stripePaymentIntentId);
}
