package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    static void main() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Way 1 get bean by type (works when beans.xml has only one OrderService type of bean)
//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();

        // Way 2 get bean by id or name
//        OrderService orderService1 = (OrderService) context.getBean("orderService2"); // name should be same as id otherwise will get error
//        orderService1.placeOrder();

        // Way 3 get bean by both id and type (works even when beans.xml has multiple OrderService type of bean)
        // best way
        OrderService orderService2 = context.getBean("orderService", OrderService.class);
        orderService2.placeOrder();

    }
}
