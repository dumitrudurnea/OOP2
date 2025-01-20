package com.example.foodStore.service;

import com.example.foodStore.model.UserAccess;
import com.example.foodStore.model.UserOrder;
import com.example.foodStore.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderService {
    @Autowired
    UserOrderRepository userOrderRepository;

    public int getTotalPrice(UserAccess userAccess) {
        int totalPrice = 0;

        for (UserOrder userOrder : userOrderRepository.findAllByUserAccessId(userAccess.getId())) {
            totalPrice += userOrder.getFoodChoice().getPrice();  // Assuming FoodChoice has a price field
        }
        return totalPrice;
    }
}
