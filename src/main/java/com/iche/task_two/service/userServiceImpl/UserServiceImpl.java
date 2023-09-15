package com.iche.task_two.service.userServiceImpl;

import com.iche.task_two.dto.request.UserRequest;
import com.iche.task_two.dto.response.UserResponse;
import com.iche.task_two.exception.UserAlreadyExistException;
import com.iche.task_two.exception.UserNotFoundException;
import com.iche.task_two.model.Users;
import com.iche.task_two.repository.UserRepository;
import com.iche.task_two.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        if (userRepository.existsByName(userRequest.getName())) {
            throw new UserAlreadyExistException(userRequest.getName() + "Already exist");
        }

        Users users = new Users();
        users.setName(userRequest.getName());
        users.setAge(userRequest.getAge());
        users.setEmail(userRequest.getEmail());

        userRepository.save(users);

        return UserResponse.builder()
                .id(users.getId())
                .name(users.getName())
                .age(users.getAge())
                .email(users.getEmail())
                .build();
    }



    @Override
    public UserResponse updateUser(String identifier, UserRequest userRequest) {
        Users users = InputChecks(identifier);

     users.setName(userRequest.getName());
     users.setAge(userRequest.getAge());
     users.setEmail(userRequest.getEmail());
     userRepository.save(users);


    return UserResponse.builder()
            .id(users.getId())
            .name(users.getName())
            .age(users.getAge())
            .email(users.getEmail())
            .build();
    }

    @Override
    public String deleteUser(String identifier) {

        Users users = InputChecks(identifier);
        userRepository.delete(users);
        return "user deleted successfully";
    }

    @Override
    public UserResponse findUser(String identifier) {
        Users users =InputChecks(identifier);

        return UserResponse.builder()
                .id(users.getId())
                .name(users.getName())
                .age(users.getAge())
                .email(users.getEmail())
                .build();
    }
    private Users InputChecks(String identifier) {
        Users users;
        if(identifier.matches("\\d+")){
            Long user_id = Long.parseLong(identifier);
            users = userRepository.findById(user_id)
                    .orElseThrow(()-> new UserNotFoundException(user_id + "not found"));
            System.out.println(users + ">>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(user_id + ">>>>>>>>>>>>>>>>>>>>>>>");

        } else {
            users = userRepository.findUserByName(identifier)
                    .orElseThrow(() -> new UserNotFoundException(identifier + "not found"));
        }
        return users;
    }

}
