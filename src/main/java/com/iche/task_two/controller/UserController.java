package com.iche.task_two.controller;

import com.iche.task_two.dto.request.UserRequest;
import com.iche.task_two.dto.response.UserResponse;
import com.iche.task_two.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api")
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        System.out.println(userRequest);
        return userService.addUser(userRequest);
    }
    @PutMapping("/api/{user_id}")
    public UserResponse updateUser(@PathVariable ("user_id") String identifier, @RequestBody UserRequest userRequest){
        return userService.updateUser(identifier,userRequest);
    }
    @DeleteMapping("/api/{user_id}")
    public String deleteUser(@PathVariable ("user_id") String identifier){
        return userService.deleteUser(identifier);
    }
    @GetMapping("/api/{user_id}")
    public UserResponse findUser(@PathVariable ("user_id") String identifier){
        return userService.findUser(identifier);
    }
}
