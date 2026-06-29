package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();
//
//        AppConfig appConfig = context.getBean(AppConfig.class);
//        appConfig.demo();

//        CartService cartService = context.getBean(CartService.class);
//        System.out.println(cartService.getValue(1));
//
//        context.close();

    }
}
