package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{orderId}")
    public String getOrderDetails(@PathVariable int orderId, Model model) {
        Optional<Order> orderOptional = orderService.getOrderById(orderId);
        Order order = orderOptional.get();
        model.addAttribute("order", order);
        return "order-details";
    }
}