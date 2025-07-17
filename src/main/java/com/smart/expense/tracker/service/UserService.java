package com.smart.expense.tracker.service;


import com.smart.expense.tracker.dto.UserDto;
import com.smart.expense.tracker.entity.User;
import java.util.List;

public interface UserService {

    User registerNewUser(UserDto user);

    List<UserDto> getAllUsers();

    boolean existsByEmail(String emailId);

    UserDto findByEmail(String emailId);

    UserDto getUserByName(String name);

}
