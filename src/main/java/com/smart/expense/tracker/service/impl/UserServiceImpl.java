package com.smart.expense.tracker.service.impl;

import com.smart.expense.tracker.dto.UserDto;
import com.smart.expense.tracker.entity.Role;
import com.smart.expense.tracker.entity.User;
import com.smart.expense.tracker.repository.UserRepo;
import com.smart.expense.tracker.service.UserService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
        user.setUserName(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(dto.getRoles()!=null ? dto.getRoles() : Set.of(Role.USER));
        userRepo.save(user);
        return userRepo.save(user);
    }

    /**
     * @return
     */
    @Override
    public List<UserDto> getAllUsers() {
        List<User> usersList = userRepo.findAll();
        List<UserDto> userList = usersList.stream()
               .map(this::convertToDto).collect(Collectors.toList());
        return  userList;
    }


    private UserDto convertToDto(User user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUserName());
        dto.setEmail(user.getEmail());
        dto.setPassword(null); // Do NOT expose password
        dto.setRoles(user.getRoles());
        return dto;
    }
}
