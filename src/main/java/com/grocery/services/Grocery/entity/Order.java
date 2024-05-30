package com.grocery.services.Grocery.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@Table(name="Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String id;
    @Column(name="userId")
    private String userId;// This should link to a User entity, not shown here
    @
    Column(name="orderDate")
    private LocalDateTime orderDate;

    @ElementCollection
    private Map<String, Integer> items; // Key: GroceryItem ID, Value: Quantity
}
