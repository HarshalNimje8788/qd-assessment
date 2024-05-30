package com.grocery.services.Grocery.controllers;

import com.grocery.services.Grocery.entity.GroceryItem;
import com.grocery.services.Grocery.entity.Order;
import com.grocery.services.Grocery.service.GroceryService;
import com.grocery.services.Grocery.service.OrderService;
import com.grocery.services.Grocery.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private GroceryService groceryService;

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
       List< GroceryItem> grow =groceryService.getAllGroceryItems();
         return ResponseEntity.ok(grow);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> placeOrder(@RequestParam  String userId, @RequestBody Map<String, Integer> items) {
      Order  order=orderService.placeOrder(userId,items);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
