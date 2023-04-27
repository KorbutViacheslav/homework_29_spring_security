package com.example.homework_29_spring_security.controllers;

import com.example.homework_29_spring_security.dto.UserDto;
import com.example.homework_29_spring_security.entity.User;
import com.example.homework_29_spring_security.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostConstruct
    public void init() {
        User admin = new User(1L,"admin", "123", "ADMIN");
        User user = new User(2L, "user", "111", "USER");
        User anonymous = new User( 3L,"anonymous", "000", "ANONYMOUS");
        userService.saveNewUser(admin);
        userService.saveNewUser(user);
        userService.saveNewUser(anonymous);
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public String getUserByID(@PathVariable Long id) {
        return userService.getUserById(id).toString();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return userService.saveNewUser(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }

}
