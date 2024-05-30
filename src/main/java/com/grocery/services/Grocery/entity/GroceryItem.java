package com.grocery.services.Grocery.entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@Table(name="Grocery_item")
public class GroceryItem {
    @Id

    @Column(name="Id")
    private String id;
    @Column(name="NAME")
    private String itemName;
    @Column(name="PRICE")
    private  double price;
    @Column(name="INVENTRYLEVEL")
    private int inventryLevel;

}
