package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;

    public OrderService(@Lazy PaymentService paymentService) {

        this.paymentService = paymentService;

        System.out.println("OrderService created !");
    }

    public void placeOrder() {
        // When calling pay(), now actual object of PaymentService will get created
        paymentService.pay();

        System.out.println("Order Placed !");
    }
}
