package com.iche.task_two.service;

import com.iche.task_two.dto.request.UserRequest;
import com.iche.task_two.dto.response.UserResponse;

public interface UserService {
    UserResponse addUser(UserRequest userRequest);

    UserResponse updateUser(String identifier, UserRequest userRequest);

    String deleteUser(String name);

    UserResponse findUser(String name);

}
