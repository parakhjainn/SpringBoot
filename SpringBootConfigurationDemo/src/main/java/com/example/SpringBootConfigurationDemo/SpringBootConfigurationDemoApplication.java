package com.example.SpringBootConfigurationDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootConfigurationDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootConfigurationDemoApplication.class, args);

//		PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
//
//		paymentGateway.print();

	}

}
