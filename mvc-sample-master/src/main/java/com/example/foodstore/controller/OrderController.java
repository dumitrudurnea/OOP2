package com.example.foodStore.controller;

import com.example.foodStore.model.UserAccess;
import com.example.foodStore.repository.UserAccessRepository;
import com.example.foodStore.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class OrderController {

    @Autowired
    private FoodOrderService foodOrderService;

    private UserAccessRepository userAccessRepository;

    public OrderController(UserAccessRepository userAccessRepository) {
        this.userAccessRepository = userAccessRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/start")
    public String start(@RequestParam String user, Model model) {

        UserAccess userAccess = new UserAccess();
        userAccess.setName(user);
        userAccess.setAccessTime(LocalDateTime.now());
        userAccess = userAccessRepository.save(userAccess);
        model.addAttribute("userAccess", userAccess);
        return "start";
    }

    @GetMapping("/endorder")
    public String endOrder(@RequestParam int userAccessId, Model m) {
        UserAccess userAccess = userAccessRepository.findById(userAccessId).get();
        m.addAttribute("userAccess", userAccess);

        return "endorder";
    }

    @GetMapping("/order-summary")
    public String orderSummary(@RequestParam int userAccessId, Model m) {
        UserAccess userAccess = userAccessRepository.findById(userAccessId).get();
        m.addAttribute("userAccess", userAccess);
        m.addAttribute("totalAmount", foodOrderService.calculateTotalAmount(userAccess));

        return "order-summary";
    }
}
