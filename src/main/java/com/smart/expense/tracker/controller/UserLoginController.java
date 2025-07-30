package com.smart.expense.tracker.controller;

import com.smart.expense.tracker.dto.AuthRequest;
import com.smart.expense.tracker.jwt.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserLoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public UserLoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/user")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(), authRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtUtil.generateToken((UserDetails) authentication.getPrincipal());
            System.out.println("token generated for new-user is: "+authRequest.getUsername()+ "is:"+token);
            return ResponseEntity.ok(new AuthRequest.AuthResponse(token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}


