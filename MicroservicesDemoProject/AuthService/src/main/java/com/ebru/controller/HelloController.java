package com.ebru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:9090
@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "Auth Service Hello!";
    }
    @GetMapping("/info")
    public String info(){
        return "Info : Auth is OK!";
    }

}
