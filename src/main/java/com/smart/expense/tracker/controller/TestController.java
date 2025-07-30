package com.smart.expense.tracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {


    @GetMapping("/secure")
    public ResponseEntity<String> testSecureEndpoint(Authentication authentication) {
        return ResponseEntity.ok("Hello, " + authentication.getName() + "! You are authenticated.");
    }
}
