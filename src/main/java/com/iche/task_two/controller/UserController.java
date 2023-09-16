package com.iche.task_two.controller;

import com.iche.task_two.dto.request.UserRequest;
import com.iche.task_two.dto.response.UserResponse;
import com.iche.task_two.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping()
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        System.out.println(userRequest);
        return userService.addUser(userRequest);
    }
    @PutMapping("/{user_id}")
    public UserResponse updateUser(@PathVariable ("user_id") String identifier, @RequestBody UserRequest userRequest){
        return userService.updateUser(identifier,userRequest);
    }
    @DeleteMapping("/{user_id}")
    public String deleteUser(@PathVariable ("user_id") String identifier){
        return userService.deleteUser(identifier);
    }
    @GetMapping("/{user_id}")
    public UserResponse findUser(@PathVariable ("user_id") String identifier){
        return userService.findUser(identifier);
    }
}
