package com.AI_Travel_Companion.paymentservice.Controller;


import com.AI_Travel_Companion.paymentservice.DTO.PaymentRequest;
import com.AI_Travel_Companion.paymentservice.DTO.PaymentResponse;
import com.AI_Travel_Companion.paymentservice.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest paymentRequest){
        PaymentResponse saved = paymentService.createPayment(paymentRequest);
        return new ResponseEntity<>(saved , HttpStatus.CREATED);
    }
}
