package com.ebru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:9091
@RestController
@RequestMapping
public class SubAController {

    @GetMapping("/")
    public String hello(){
        return "SubA Service Hello!";
    }
    @GetMapping("/info")
    public String info(){
        return "Info : SubA is OK!";
    }

}
