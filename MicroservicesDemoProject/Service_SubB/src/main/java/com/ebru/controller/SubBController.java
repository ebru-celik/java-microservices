package com.ebru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:9092
@RestController
@RequestMapping
public class SubBController {

    @GetMapping("/")
    public String hello(){
        return "SubB Service Hello!";
    }
    @GetMapping("/info")
    public String info(){
        return "Info : SubB is OK!";
    }

}
