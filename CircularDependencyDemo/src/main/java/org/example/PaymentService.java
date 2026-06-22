package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    @Autowired
    private OrderService orderService;

    //    @Autowired -> Optional bcz only 1 constructor
//    public PaymentService(OrderService orderService) {
//        this.orderService = orderService;
//    }

    public void pay() {
        System.out.println("Payment Done !");

        // Not it's responsibility
//        orderService.getOrderDetails();
    }
}
