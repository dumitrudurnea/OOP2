package com.example.foodStore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name="user_order")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_access_id")
    private UserAccess userAccess;

    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

    @ManyToOne
    @JoinColumn(name = "food_choice_id")
    private FoodChoice foodChoice;

    private int quantity;
}
