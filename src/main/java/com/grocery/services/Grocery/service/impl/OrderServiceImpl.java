package com.grocery.services.Grocery.service.impl;

import com.grocery.services.Grocery.entity.GroceryItem;
import com.grocery.services.Grocery.entity.Order;
import com.grocery.services.Grocery.repositeries.GroceryRepositary;
import com.grocery.services.Grocery.repositeries.OrderRepository;
import com.grocery.services.Grocery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private GroceryRepositary groceryRepositary;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(String userId, Map<String, Integer> items) {
        // Validate and update inventory
        items.forEach((itemId, quantity) -> {
            GroceryItem item = groceryRepositary.findById(itemId).orElseThrow();
            if (item.getInventryLevel() < quantity) {
                throw new RuntimeException("Insufficient inventory for item " + itemId);
            }
            item.setInventryLevel(item.getInventryLevel()- quantity);
            groceryRepositary.save(item);
        });

        Order order = new Order();
        order.setUserId(userId);
        order.setOrderDate(LocalDateTime.now());
        order.setItems(items);

        return orderRepository.save(order);
    }



}

