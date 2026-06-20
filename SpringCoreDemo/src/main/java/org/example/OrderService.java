package org.example;

import org.example.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class OrderService {


    // Constructor Injection -> Preferred
    private final PaymentService paymentService;

    @Autowired // Optional if there is only one Constructor
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Setter Injection
//    private PaymentService paymentService;
//
//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    // Field Injection -> Not Recommended
//    @Autowired
//    private PaymentService paymentService;

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order placed !");
    }
}
