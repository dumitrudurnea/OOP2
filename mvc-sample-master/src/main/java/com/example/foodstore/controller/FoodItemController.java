package com.example.foodStore.controller;

import com.example.foodStore.model.FoodItem;
import com.example.foodStore.model.UserOrder;
import com.example.foodStore.model.UserAccess;
import com.example.foodStore.repository.FoodItemRepository;
import com.example.foodStore.repository.UserAccessRepository;
import com.example.foodStore.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoodItemController {

    @Autowired
    private UserAccessRepository userAccessRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private UserOrderRepository userOrderRepository;

    public FoodItemController(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    @PostMapping("/submit-food-order")
    public String submitFoodOrder(UserOrderForm form, @RequestParam int userAccessId) throws Exception {
        UserAccess userAccess = userAccessRepository.findById(userAccessId).orElseThrow(() -> new Exception("No user access row found"));
        FoodItem foodItem = foodItemRepository.findById(form.getFoodItem()).get();

        UserOrder userOrder = new UserOrder();
        userOrder.setUserAccess(userAccess);
        userOrder.setFoodItem(foodItem);
        userOrderRepository.save(userOrder);

        return "redirect:/view-next-food-item?userAccessId=" + userAccess.getId() + "&foodItemId=" + foodItem.getId();
    }

    @GetMapping("/food-item")
    public String foodItem(@RequestParam int userAccessId, @RequestParam int foodItemId, Model m) throws Exception {
        UserAccess userAccess = userAccessRepository.findById(userAccessId).get();
        FoodItem foodItem = foodItemRepository.findById(foodItemId).orElseThrow(() -> new Exception("No food item row found"));

        m.addAttribute("userAccess", userAccess);
        m.addAttribute("foodItem", foodItem);

        return "food-item";
    }

    @GetMapping("/view-next-food-item")
    public String viewNextFoodItem(@RequestParam int userAccessId, @RequestParam int foodItemId, Model m) throws Exception {
        UserAccess userAccess = userAccessRepository.findById(userAccessId).orElseThrow(() -> new Exception("No user access row found"));
        foodItemId++;
        FoodItem foodItem = foodItemRepository.findById(foodItemId).orElse(null);
        if (foodItem != null) {
            m.addAttribute("foodItem", foodItem);
            m.addAttribute("userAccess", userAccess);
        } else {
            return "redirect:/endorder?userAccessId=" + userAccess.getId();
        }
        return "redirect:/food-item?userAccessId=" + userAccess.getId() + "&foodItemId=" + foodItem.getId();
    }
}
