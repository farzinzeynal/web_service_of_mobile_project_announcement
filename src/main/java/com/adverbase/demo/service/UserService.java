package com.adverbase.demo.service;

import com.adverbase.demo.model.request.LoginRequest;
import com.adverbase.demo.model.request.UserRequset;
import com.adverbase.demo.model.response.UserResponse;

import java.util.List;

public interface UserService
{
    public UserResponse save(UserRequset userRequset);

    boolean authenticate(LoginRequest loginRequest);
}
