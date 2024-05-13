package dev.sakshi.paymentservicefinal.services;

import dev.sakshi.paymentservicefinal.services.paymentgateway.PaymentGateway;
import dev.sakshi.paymentservicefinal.services.paymentgateway.RazorpayPaymentGateway;
import dev.sakshi.paymentservicefinal.services.paymentgateway.StripePaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {
    private RazorpayPaymentGateway razorpayPaymentGateway;
    private StripePaymentGateway stripePaymentGateway;

    public PaymentGatewayChooserStrategy(
            RazorpayPaymentGateway razorpayPaymentGateway,
            StripePaymentGateway stripePaymentGateway
    ) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway getBestPaymentGateway() {
//        int randomInt = new Random().nextInt();
//
//        if (randomInt % 2 == 0) {
//            return razorpayPaymentGateway;
//        }
//
        return stripePaymentGateway;
//        return razorpayPaymentGateway;
    }


}
