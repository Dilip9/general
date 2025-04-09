package com.gouri.general.service.impl;

import com.gouri.general.exception.UserNotFoundException;
import com.gouri.general.model.Users;
import com.gouri.general.model.dto.UserRequest;
import com.gouri.general.model.dto.UserResponse;
import com.gouri.general.repository.UserRepository;
import com.gouri.general.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Builder
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse createNewUser(UserRequest userRequest) {
        // Check if the user already exists
        userRepository.findByEmailId(userRequest.getEmail()).ifPresent(user -> {
            throw new UserNotFoundException("User already exists with email: " + userRequest.getEmail(), HttpStatus.CONFLICT);
        });
        Users savedUser = userRepository.save(userRequest.toUserInfo());
        return UserResponse.builder()
                .id(Long.valueOf(savedUser.getId()))
                .email(savedUser.getEmailId())
                .phoneNumber(savedUser.getPhoneNumber())
                .name(savedUser.getName())
                .nationality(savedUser.getNationality())
                .build();
    }
}
