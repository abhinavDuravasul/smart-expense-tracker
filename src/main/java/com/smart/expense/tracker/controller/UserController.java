package com.smart.expense.tracker.controller;

import com.smart.expense.tracker.dto.UserDto;
import com.smart.expense.tracker.entity.User;
import com.smart.expense.tracker.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<User> register(UserDto userDto){
       User savedUser = userService.registerNewUser(userDto);
        return ResponseEntity.ok().header("xyz","12345")
                .body(savedUser);
    }
}
