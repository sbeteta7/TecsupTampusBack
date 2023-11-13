package com.tampusdev.tampus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {

    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello from API";
    }

    @GetMapping("/sayHelloProtected")
    public String sayHiProtected(){
        return "Hello from API protected";
    }
}
