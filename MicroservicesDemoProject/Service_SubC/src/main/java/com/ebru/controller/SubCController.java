package com.ebru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:9093
@RestController
@RequestMapping
public class SubCController {

    @GetMapping("/")
    public String hello(){
        return "SubC Service Hello!";
    }
    @GetMapping(value = "/info")
    public String info(){
        return "Info : SubC is OK!";
    }

}
