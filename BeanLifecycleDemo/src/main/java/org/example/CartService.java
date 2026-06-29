package org.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartService implements InitializingBean {

    Map<Integer, String> mp;

    public CartService() {
        mp = new HashMap<>();
        System.out.println("CartService constructor called !");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean is Ready !");
        mp.put(1, "Parakh");
        mp.put(2, "Aditya");
    }

    public void addToCart() {
        System.out.println("Added to cart !");
    }

    public String getValue(Integer key) {
        return mp.get(key);
    }
}
