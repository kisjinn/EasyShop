package dev.sakshi.payment.controllers;

import dev.sakshi.payment.dtos.InitiatePaymentRequestDto;
import dev.sakshi.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;
    PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    @PostMapping
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto request) {
        //return null
        return paymentService.initiatePayment(request.getOrderId(), request.getEmail(), request.getPhoneNumber(), request.getAmount());
    }

}
