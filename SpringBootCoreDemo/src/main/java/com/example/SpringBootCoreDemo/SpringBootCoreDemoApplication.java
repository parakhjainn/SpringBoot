package com.example.SpringBootCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCoreDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootCoreDemoApplication.class, args);

		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();

		// In spring boot, we don't store context and don't call functions using getBean from context
	}

	// FYI
	@Bean
	public UserService getUserServiceBean() {
		return new UserService();
	}

}
