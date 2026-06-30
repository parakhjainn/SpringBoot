package com.example.SpringBootConfigurationDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    @Value("${paymentGateway.type:razorpay}")
    private String type;

    @Value("${paymentGateway.retryCount:3}")
    private int retryCount;

//    public PaymentGateway(@Value("${paymentGateway.type}") String type,
//                          @Value("${paymentGateway.retryCount}") int retryCount) {
//        this.type = type;
//        this.retryCount = retryCount;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }
}
