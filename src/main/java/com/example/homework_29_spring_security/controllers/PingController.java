package com.example.homework_29_spring_security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PingController {
    @GetMapping("/ping")
    public String getPing() {
        return "PING!";
    }

    @GetMapping("/")
    public String getApp() {
        return "WORK APP!";
    }
}
