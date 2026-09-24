package com.AI_Travel_Companion.paymentservice.Service;


import com.AI_Travel_Companion.paymentservice.Repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;


}
