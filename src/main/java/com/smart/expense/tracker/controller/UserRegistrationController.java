package com.smart.expense.tracker.controller;

import com.smart.expense.tracker.dto.RegisterRequest;
import com.smart.expense.tracker.entity.User;
import com.smart.expense.tracker.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserRegistrationController {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserRegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        System.out.println("Registration endpoint hit");
        if (userRepository.existsByUserName(request.getUsername())) {
            return ResponseEntity.badRequest().body("Username already taken");
        }
        User user = new User();
        user.setUserName(request.getUsername());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

}
//
//🔁 Full Login Flow (Simplified)
//🔐 User sends /login/user with:
//
//{
//    "username": "john",
//        "password": "password123"
//}


//🧱 Spring Security Filter intercepts the request
//
//⚙️ UsernamePasswordAuthenticationFilter creates a UsernamePasswordAuthenticationToken
//
//🔄 It passes this token to your configured AuthenticationManager
//
//🧠 DaoAuthenticationProvider is used:
//
//It loads the user using your UserDetailsService
//
//Fetches hashed password from DB
//
//Uses passwordEncoder.matches() internally to validate
//
//✅ So in summary:
//You use .encode() manually during registration
//
//Spring Security uses .matches() automatically during login inside DaoAuthenticationProvider
//
//You only configure the PasswordEncoder bean, and Spring handles the rest internally


//2

//🔁 When Does Spring Use It?
//Here’s the actual flow:
//
//        ✅ A login request hits your /login endpoint.
//
//        🚦 Spring Security's UsernamePasswordAuthenticationFilter intercepts the request.
//
//        ⚙️ It creates a UsernamePasswordAuthenticationToken with the username & password.
//
//👉 This token is passed to the AuthenticationManager.
//
//✅ AuthenticationManager delegates to the AuthenticationProvider (your bean).
//
//        🔍 DaoAuthenticationProvider:
//
//Calls your UserDetailsService.loadUserByUsername(...)
//
//Retrieves the UserDetails from DB
//
//Uses PasswordEncoder.matches(...) to compare raw vs hashed password
//
//🎯 If credentials are valid, it returns a fully authenticated Authentication object.
//
//        🔐 This authenticated object is set in the SecurityContextHolder, marking the user as logged in.

//[UsernamePasswordAuthenticationFilter]
//        |
//v
// [AuthenticationManager]
//        |
//v
//[DaoAuthenticationProvider (your bean)]
//        |                         |
//v                         v
//loadUserByUsername()   passwordEncoder.matches()
//     |                         |
//             -------- SUCCESS ---------
//        |
//v
//Authenticated Authentication Object → SecurityContextHolder

//
//Questions
//🧠 Final Tips for Resume & Concept Clarity
//You can say:
//
//🔐 Implemented JWT-based stateless authentication using Spring Security, including custom UserDetailsService, JwtAuthenticationFilter, and secure password hashing with BCrypt.
//
//And during interviews, confidently explain:
//
//How password encoding works
//
//How Spring uses UserDetailsService
//
//What filters are, and how your JWT filter is added
//
//Why you disable CSRF and use stateless sessions