package com.example.SpringBootConfigurationDemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringBootConfigurationDemoRunner implements ApplicationRunner {

    private PaymentGateway paymentGateway;

    public SpringBootConfigurationDemoRunner(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        paymentGateway.print();
    }
}
