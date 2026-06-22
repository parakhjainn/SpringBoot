package org.example;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    public OrderService() {
        System.out.println("OrderService Created !");
    }

    public void placeOrder() {
        System.out.println("Order placed !");
    }


}
