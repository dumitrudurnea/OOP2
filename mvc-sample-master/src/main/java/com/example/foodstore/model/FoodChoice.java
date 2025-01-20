package com.example.foodStore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name="food_choice")
public class FoodChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;
}
