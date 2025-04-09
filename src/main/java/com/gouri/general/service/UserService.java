package com.gouri.general.service;

import com.gouri.general.model.dto.UserRequest;
import com.gouri.general.model.dto.UserResponse;

public interface UserService {

    public UserResponse createNewUser(UserRequest userRequest);
}
