package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// Way - 1 -> Only for console printing
		System.out.println("Hello World ! : Way - 1");

		// Way - 2 -> Only for console printing
		HelloController helloController = new HelloController();
		System.out.println(helloController.sayHello() + " : Way - 2");
	}
}

/*
	https://start.spring.io/
	- maven
	- stable version
	- default artifact, group, demo
	- JAR
	- Java 21
	- Dependency - Spring Web
	- Create Project
*/

/*
	server.port = 9090 in application.properties
	http://localhost:9090/hello
	http://localhost:9090/bye
 */