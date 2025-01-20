package com.example.foodStore.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Data
@Entity
@Table(name="food_item")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double price;

    private int quantity;

    @OneToMany(mappedBy = "foodItem", fetch = FetchType.EAGER)
    private List<FoodChoice> choices;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return Double.compare(foodItem.price, price) == 0 && quantity == foodItem.quantity && Objects.equals(name, foodItem.name) && Objects.equals(choices, foodItem.choices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity, choices);
    }
}
