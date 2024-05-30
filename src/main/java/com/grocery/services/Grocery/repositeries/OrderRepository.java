package com.grocery.services.Grocery.repositeries;

import com.grocery.services.Grocery.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String>{

    }

