package com.example.homework_29_spring_security.repository;

import com.example.homework_29_spring_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
