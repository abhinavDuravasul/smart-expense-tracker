package com.smart.expense.tracker.service.impl;

import com.smart.expense.tracker.dto.UserDto;
import com.smart.expense.tracker.entity.Role;
import com.smart.expense.tracker.entity.User;
import com.smart.expense.tracker.repository.UserRepo;
import com.smart.expense.tracker.service.UserService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

   // private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * @param dto
     * @return
     */
    @Override
    public User registerNewUser(UserDto dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPasswordHash((dto.getPassword()));
        user.setRoles(dto.getRoles()!=null ? dto.getRoles() : Set.of(Role.USER));
        return userRepo.save(user);
    }
}
