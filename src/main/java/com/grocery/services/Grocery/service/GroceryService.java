package com.grocery.services.Grocery.service;

import com.grocery.services.Grocery.entity.GroceryItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GroceryService {

    public GroceryItem updateGroceryItem(GroceryItem groceryItem);

    public List<GroceryItem> getAllGroceryItems();
    public void deleteGroceryItem(String id);
    public GroceryItem addGroceryItem(GroceryItem groceryItem);
    public  GroceryItem getSingalGroceryIteams(String id);

    public GroceryItem updateInventoryLevel(String id, int inventoryLevel);

}
