package com.example.foodStore.repository;

import com.example.foodStore.model.FoodItem;
import org.springframework.data.repository.CrudRepository;

public interface FoodItemRepository extends CrudRepository<FoodItem, Integer> {
}
