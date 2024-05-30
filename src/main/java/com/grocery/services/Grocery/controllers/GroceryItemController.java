package com.grocery.services.Grocery.controllers;
import com.grocery.services.Grocery.entity.GroceryItem;
import com.grocery.services.Grocery.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class GroceryItemController {
    @Autowired
    private GroceryService groceryService;


    @PostMapping ("/items")
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem groceryItem) {
         GroceryItem groceryItem1=groceryService.addGroceryItem(groceryItem);
         return ResponseEntity.status(HttpStatus.CREATED).body(groceryItem1);
    }

    @GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        List<GroceryItem> groceryItem2= groceryService.getAllGroceryItems();
        return ResponseEntity.ok(groceryItem2);
    }
    @GetMapping("/item2/{id}")
    public ResponseEntity<GroceryItem> getSingalGroceryItems(@PathVariable String id) {
        GroceryItem groceryItem2=  groceryService.getSingalGroceryIteams(id);
        return ResponseEntity.ok(groceryItem2);
    }

    @DeleteMapping("/items/{id}")
    public void deleteGroceryItem(@PathVariable String id) {
        groceryService.deleteGroceryItem(id);
    }

    @PutMapping("/items")
    public ResponseEntity<GroceryItem> updateGroceryItem(@RequestBody GroceryItem groceryItem) {
        GroceryItem groceryItem15= groceryService.updateGroceryItem(groceryItem);
        return ResponseEntity.status(HttpStatus.OK).body(groceryItem15);
    }

   @PutMapping("/items/{id}/inventory")
    public GroceryItem updateInventoryLevel(@PathVariable String id, @RequestParam int inventoryLevel) {
        return groceryService.updateInventoryLevel(id, inventoryLevel);
 }
}

