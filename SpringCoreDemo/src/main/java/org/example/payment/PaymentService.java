package org.example.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public interface PaymentService {

    void pay();

}
