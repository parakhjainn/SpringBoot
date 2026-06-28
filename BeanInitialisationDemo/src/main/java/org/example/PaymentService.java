package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PaymentService {

    public PaymentService(){
        System.out.println("PaymentService Created !");
    }

    public void pay() {
        System.out.println("Payment Done !");
    }
}
