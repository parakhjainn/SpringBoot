package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        orderService.placeOrder();
    }
}
