package com.example.homework_29_spring_security.repository;

import com.example.homework_29_spring_security.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
