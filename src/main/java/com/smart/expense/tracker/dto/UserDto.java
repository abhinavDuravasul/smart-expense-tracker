package com.smart.expense.tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.expense.tracker.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {

    @JsonProperty("user_name")
    private String username;
    private String password;
    private String email;
    private Set<Role> roles;
}
