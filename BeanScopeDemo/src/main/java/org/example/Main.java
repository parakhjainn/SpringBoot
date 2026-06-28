package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService orderService = context.getBean(OrderService.class);
//
//        OrderService orderService2 = context.getBean(OrderService.class);
//
//        System.out.println(orderService == orderService2);

        /*
        Output:
            OrderService Created !
            true
         */


    }
}
