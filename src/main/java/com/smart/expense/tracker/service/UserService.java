package com.smart.expense.tracker.service;


import com.smart.expense.tracker.dto.UserDto;
import com.smart.expense.tracker.entity.User;

public interface UserService {

    User registerNewUser(UserDto user);
}
