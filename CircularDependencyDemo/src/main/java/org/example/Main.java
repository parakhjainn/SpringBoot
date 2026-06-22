package org.example;

import org.example.JavaCDDemo.A;
import org.example.JavaCDDemo.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();

//        A a  = new A(new B()); // -> Wrong



    }
}
