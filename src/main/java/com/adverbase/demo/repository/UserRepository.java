package com.adverbase.demo.repository;

import com.adverbase.demo.entity.UserEntity;
import com.adverbase.demo.model.response.AdverResponse;
import com.adverbase.demo.model.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>
{
    UserEntity findByUsername(String username);

    @Query(value = "SELECT * FROM USERS WHERE user_name = 'eldar.zeynal' && password_hash = '$2a$10$6ZIbqREsNKbO1AO2RhR/..mrO0kSupL/Y/hCJJn7VmBfdhO8yRevi' ", nativeQuery = true)
    List<UserResponse> authenticate();

}
