package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartService implements BeanNameAware, ApplicationContextAware
        /* DisposableBean */ {

    Map<Integer, String> mp;

    public CartService() {
        mp = new HashMap<>();
        System.out.println("CartService constructor called !");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext name is " + applicationContext.getClass());
    }

    @PostConstruct
    public void start2() {
        System.out.println("Bean is ready !");
        mp.put(1, "Parakh");
        mp.put(2, "Aditya");
    }

    public void addToCart() {
        System.out.println("Added to cart !");
    }

    public String getValue(Integer key) {
        return mp.get(key);
    }

    public void start() {
        System.out.println("Bean is ready !");
        mp.put(1, "Parakh");
        mp.put(2, "Aditya");
    }

//    @Override
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("Bean is Destroyed !");
//    }

//    public void stop () {
//        mp.clear();
//        System.out.println("Bean is Destroyed !");
//    }

    @PreDestroy
    public void stop () {
        mp.clear();
        System.out.println("Bean is Destroyed !");
    }
}
