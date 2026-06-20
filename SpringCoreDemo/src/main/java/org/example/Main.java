package org.example;

import org.exam.CartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

//        PaymentService paymentService = context.getBean(PaymentService.class);
//        paymentService.pay();

        // cannot add @Component on Card Service because .class files are only readable
//        CartService cs = new CartService();
//        cs.addToCart();

        // After @Bean added in AppConfig
//        User user = context.getBean(User.class);
//        System.out.println(user.getName());

        // After @Bean added in AppConfig
//        CartService cs = context.getBean(CartService.class);
//        cs.addToCart();
    }
}
