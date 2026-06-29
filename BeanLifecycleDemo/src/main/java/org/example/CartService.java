package org.example;

import java.util.HashMap;
import java.util.Map;

public class CartService {

    Map<Integer, String> mp;

    public CartService() {
        mp = new HashMap<>();
        System.out.println("CartService constructor called !");
    }

    public void start() {
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
}
