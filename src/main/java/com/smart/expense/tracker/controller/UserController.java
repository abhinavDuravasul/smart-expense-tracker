package com.smart.expense.tracker.controller;

import com.smart.expense.tracker.dto.UserDto;
import com.smart.expense.tracker.entity.User;
import com.smart.expense.tracker.service.UserService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


   // @PermitAll
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDto userDto){
        User savedUser = userService.registerNewUser(userDto);
        return ResponseEntity.ok().header("xyz", "12345")
                .body(savedUser);
    }

  //  @PermitAll
    @GetMapping("/getAll")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/email")
    public ResponseEntity<Boolean> searchByEmail(@RequestParam(value = "email", required = true) String emailId) {
     //boolean exists = userService.existsByEmail(emailId);
     return ResponseEntity.ok().body(userService.existsByEmail(emailId));
    }

    @GetMapping("/emailId")
    public ResponseEntity<UserDto> getByEmail(@RequestParam String emailId) {
        return ResponseEntity.ok(userService.findByEmail(emailId));
    }

    @GetMapping("/getByName")
    public ResponseEntity<UserDto> searchByName(@RequestParam(value ="name", required = true) String name){
      return ResponseEntity.status(HttpStatus.FOUND).body( userService.getUserByName(name));

    }
}
