package com.tampusdev.tampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doc")
public class ExampleController {
    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello from API";
    }
}
