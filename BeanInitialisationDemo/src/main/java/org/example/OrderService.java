package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {

        this.paymentService = paymentService;

        System.out.println("OrderService created !");
    }

    public void placeOrder() {
        paymentService.pay();

        System.out.println("Order Placed !");
    }

    public void getOrderDetails() {
        System.out.println("Order Details !");
    }
}
