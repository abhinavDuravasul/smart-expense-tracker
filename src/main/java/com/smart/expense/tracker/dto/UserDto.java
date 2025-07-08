package com.smart.expense.tracker.dto;

import com.smart.expense.tracker.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {

    private String userName;
    private String password;
    private String email;
    private Set<Role> roles;
}
