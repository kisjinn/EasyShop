package dev.sakshi.paymentservicefinal.controllers;

import dev.sakshi.paymentservicefinal.dtos.InitiatePaymentRequestDto;
import dev.sakshi.paymentservicefinal.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto request) {
        return paymentService.initiatePayment(request.getOrderId(), request.getEmail(), request.getPhoneNumber(), request.getAmount());
    }
}
