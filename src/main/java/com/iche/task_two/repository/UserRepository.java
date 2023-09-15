package com.iche.task_two.repository;

import com.iche.task_two.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    boolean existsByName(String name);
    Optional<Users> findById(Long aLong);
    Optional<Users> findUserByName (String name);

}
