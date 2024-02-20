package com.ebru.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost/fallback

@RequiredArgsConstructor
@RestController
@RequestMapping("/fallback")
public class FallbackController {

    // http://localhost/fallback/auth
    @GetMapping("/auth")
    public ResponseEntity<String> fallbackAuth(){
        return ResponseEntity.ok("AuthService ist temporarily out of service");
    }

    // http://localhost/fallback/user
    @GetMapping("/user")
    public ResponseEntity<String> fallbackUser(){
        return ResponseEntity.ok("UserService ist temporarily out of service");
    }

    // http://localhost/fallback/agent
    @GetMapping("/agent")
    public ResponseEntity<String> fallbackAgent(){
        return ResponseEntity.ok("AgentService ist temporarily out of service");
    }

    // http://localhost/fallback/buyer
    @GetMapping("/buyer")
    public ResponseEntity<String> fallbackBuyer(){
        return ResponseEntity.ok("BuyerService ist temporarily out of service");
    }

    // http://localhost/fallback/property
    @GetMapping("/property")
    public ResponseEntity<String> fallbackProperty(){
        return ResponseEntity.ok("PropertyService ist temporarily out of service");
    }

    // http://localhost/fallback/seller
    @GetMapping("/seller")
    public ResponseEntity<String> fallbackSeller(){
        return ResponseEntity.ok("SellerService ist temporarily out of service");
    }
}
