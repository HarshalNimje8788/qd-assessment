package com.grocery.services.Grocery.service;

import com.grocery.services.Grocery.entity.Order;

import java.util.Map;

public interface OrderService {
    public Order placeOrder(String userId, Map<String, Integer> items);


}
