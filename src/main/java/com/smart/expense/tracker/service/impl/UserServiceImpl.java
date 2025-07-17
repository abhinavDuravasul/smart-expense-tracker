package com.smart.expense.tracker.service.impl;

import com.smart.expense.tracker.constants.ApplicationConstants;
import com.smart.expense.tracker.dto.UserDto;
import com.smart.expense.tracker.entity.Role;
import com.smart.expense.tracker.entity.User;
import com.smart.expense.tracker.exception.InvalidEmailException;
import com.smart.expense.tracker.exception.InvalidUserException;
import com.smart.expense.tracker.repository.UserRepo;
import com.smart.expense.tracker.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static com.smart.expense.tracker.constants.ApplicationConstants.INVALID_EMAIL;
import static com.smart.expense.tracker.constants.ApplicationConstants.USER_NOT_FOUND;

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

    /**
     * @return
     */
    @Override
    public boolean existsByEmail(String emailId) {
        return userRepo.existsByEmail(emailId);
    }

    /**
     * @param emailId
     * @return
     */
    @Override
    public UserDto findByEmail(String emailId) {
        User exists = userRepo.findByEmail(emailId).orElseThrow(()->new InvalidEmailException(INVALID_EMAIL + emailId));
       return  convertToDto(exists);
    }

    /**
     * @param name
     * @return
     */
    @Override
    public UserDto getUserByName(String name) {
      User user = userRepo.findByUserName(name).orElseThrow(()-> new InvalidUserException(USER_NOT_FOUND + name));
       return convertToDto(user);
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
