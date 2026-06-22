package org.example;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    private OrderService orderService;

    //    @Autowired -> Optional bcz only 1 constructor
    public PaymentService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void pay() {
        System.out.println("Payment Done !");

        orderService.getOrderDetails();
    }
}
