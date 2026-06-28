package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Until we use below lines, object will be not be created because of Lazy Initialization
        OrderService orderService = context.getBean(OrderService.class);
        PaymentService paymentService = context.getBean(PaymentService.class);
    }
}
