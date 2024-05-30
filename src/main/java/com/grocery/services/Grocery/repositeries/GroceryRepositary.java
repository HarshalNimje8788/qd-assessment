package com.grocery.services.Grocery.repositeries;

import com.grocery.services.Grocery.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroceryRepositary extends JpaRepository<GroceryItem,String> {


}
