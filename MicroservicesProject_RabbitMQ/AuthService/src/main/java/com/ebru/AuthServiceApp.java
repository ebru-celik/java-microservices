package com.ebru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class AuthServiceApp {
    public static void main(String[] args) {

        SpringApplication.run(AuthServiceApp.class,args);
    }
}