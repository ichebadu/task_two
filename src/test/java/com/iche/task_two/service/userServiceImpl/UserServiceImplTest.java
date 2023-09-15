package com.iche.task_two.service.userServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iche.task_two.dto.request.UserRequest;
import com.iche.task_two.dto.response.UserResponse;
import com.iche.task_two.model.Users;
import com.iche.task_two.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;


    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setName("chukwu");
        userRequest.setAge(23);
        userRequest.setEmail("chukwu.iche@gmail.com");
        System.out.println(userRequest);

        when(userRepository.existsByName("chukwu")).thenReturn(false);


        Users users = new Users();

        users.setName(userRequest.getName());
        users.setAge(userRequest.getAge());
        users.setEmail(userRequest.getEmail());

        when(userRepository.save(any(Users.class))).thenReturn(users);

        UserResponse userResponse = userService.addUser(userRequest);


        assertNotNull(userResponse);
        assertEquals("chukwu", userResponse.getName());
    }

    @Test
    public void testUpdateUser() {

        String identifier = "1";
        UserRequest userRequest = new UserRequest();
        userRequest.setName("UpdatedUser");
        userRequest.setAge(35);
        userRequest.setEmail("updated@example.com");
        Users existingUser = new Users();
        existingUser.setId(1L);
        existingUser.setName("OriginalUser");
        existingUser.setAge(30);
        existingUser.setEmail("original@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(Users.class))).thenReturn(existingUser);

        UserResponse response = userService.updateUser(identifier, userRequest);


        assertNotNull(response);
        assertEquals("UpdatedUser", response.getName());

    }
    @Test
    public void testDeleteUser() {

        String identifier = "1";
        Users existingUser = new Users();
        existingUser.setId(1L);
        existingUser.setName("UserToDelete");
        existingUser.setAge(30);
        existingUser.setEmail("delete@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        doNothing().when(userRepository).delete(existingUser);

        String response = userService.deleteUser(identifier);


        assertNotNull(response);
        assertEquals("user deleted successfully", response);
    }

    @Test
    public void testFindUser() {

        String identifier = "1";
        Users existingUser = new Users();
        existingUser.setId(1L);
        existingUser.setName("FoundUser");
        existingUser.setAge(30);
        existingUser.setEmail("found@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));

        UserResponse response = userService.findUser(identifier);


        assertNotNull(response);
        assertEquals("FoundUser", response.getName());

    }
}
