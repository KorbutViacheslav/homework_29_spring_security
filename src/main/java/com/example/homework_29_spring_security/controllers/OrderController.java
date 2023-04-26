package com.example.homework_29_spring_security.controllers;

import com.example.homework_29_spring_security.entity.Order;
import com.example.homework_29_spring_security.entity.Product;
import com.example.homework_29_spring_security.service.OrderService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostConstruct
    private void initDate() {
        List<Product> productList1 = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            productList1.add(new Product((long) i, "product" + i, 10.0 + i));
        }

        List<Product> productList2 = new ArrayList<>();
        for (int i = 4; i <= 7; i++) {
            productList2.add(new Product((long) i, "product" + i, 10.0 + i));
        }

        Order order1 = new Order(1L, LocalDate.now(), sumCoast(productList1),
                productList1);
        Order order2 = new Order(2L, LocalDate.now().minusDays(1), sumCoast(productList2),
                productList2);

        orderService.saveOrder(order1);
        orderService.saveOrder(order2);
    }

    private Double sumCoast(List<Product> productList) {
        return productList.stream().mapToDouble(Product::getCost).sum();

    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id).orElse(null);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

/*    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }*/
}
