package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String sayHello() {
//        return "Hello World !";
        return "<h1> Hello World ! </h1>";
    }

    @GetMapping("bye")
    public String sayBye() {
//        return "Hello World !";
        return "<h1> Bye ! </h1>";
    }

}
