package com.example.homework_29_spring_security.controllers;

import com.example.homework_29_spring_security.entity.User;
import com.example.homework_29_spring_security.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostConstruct
    public void init(){
        User admin=new User(1L,"admin","123","ADMIN");
        User user=new User(2L,"user","111","USER");
        User anonymous=new User(3L,"anonymous","000","ANONYMOUS");
        userService.saveNewUser(admin);
        userService.saveNewUser(user);
        userService.saveNewUser(anonymous);
    }
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public String getUserByID(@PathVariable Long id){
        return userService.getUserById(id).toString();
    }

}
