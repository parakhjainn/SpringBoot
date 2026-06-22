package org.example.SimpleJavaDemo;

import org.example.OrderService;
import org.springframework.stereotype.Component;

@Component
public class B {

    private OrderService orderService;

    public B(OrderService orderService) {
        this.orderService = orderService;
    }
}
