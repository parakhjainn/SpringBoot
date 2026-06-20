package org.example;

import org.exam.CartService;
import org.example.payment.CardPayment;
import org.example.payment.PaymentService;
import org.example.payment.UpiPayment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

    @Bean
    public User createUser() {
        return new User("Parakh", 26);
    }

    @Bean
    public CartService createCardService() {
        return new CartService();
    }

    // Another way to create bean of CardPayment (first way is using @Component)
    @Bean
//    @Primary
    @Qualifier
    public CardPayment createCardPayment() {
        return new CardPayment();
    }

    // Another way to create bean of UpiPayment (first way is using @Component)
    @Bean
    @Qualifier
    public UpiPayment createUpiPayment() {
        return new UpiPayment();
    }

    // Another way to create bean of OrderService (first way is using @Component)
    // Constructor Injection
    @Bean
    public OrderService createOrderService(@Qualifier("createUpiPayment") PaymentService paymentService) {
        return new OrderService(paymentService);
    }

    // Another way to create bean of OrderService (first way is using @Component)
    // Setter Injection
//    @Bean
//    public OrderService createOrderService() {
//        return new OrderService();
//    }

}
