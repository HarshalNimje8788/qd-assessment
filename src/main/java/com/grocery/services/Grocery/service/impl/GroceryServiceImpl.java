package com.grocery.services.Grocery.service.impl;

import com.grocery.services.Grocery.entity.GroceryItem;
import com.grocery.services.Grocery.exception.groceryItemNotFoundException;
import com.grocery.services.Grocery.repositeries.GroceryRepositary;
import com.grocery.services.Grocery.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroceryServiceImpl implements GroceryService {
    @Autowired
    private GroceryRepositary groceryRepositary;
    @Override
    public GroceryItem updateGroceryItem(GroceryItem groceryItem) {
          return groceryRepositary.save(groceryItem);
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return  groceryRepositary.findAll();
    }

    @Override
    public void deleteGroceryItem(String id) {
        groceryRepositary.deleteById(id);
    }

    @Override
    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        String randumid= UUID.randomUUID().toString();
        groceryItem.setId(randumid);
        System.out.println(randumid);
        return groceryRepositary.save(groceryItem);
    }

    @Override
    public GroceryItem getSingalGroceryIteams(String id) {
        return groceryRepositary.findById(id).orElseThrow(()->new groceryItemNotFoundException("given grocery item currently not avilable !!"+id));
    }

    @Override
    public GroceryItem updateInventoryLevel(String id, int inventoryLevel) {
        GroceryItem groceryItem= groceryRepositary.findById(id).orElseThrow();
        groceryItem.setInventryLevel(inventoryLevel);
        return groceryRepositary.save(groceryItem);
    }
}
