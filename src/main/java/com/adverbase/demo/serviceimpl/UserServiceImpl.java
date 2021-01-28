package com.adverbase.demo.serviceimpl;

import com.adverbase.demo.entity.UserEntity;
import com.adverbase.demo.model.request.LoginRequest;
import com.adverbase.demo.model.request.UserRequset;
import com.adverbase.demo.model.response.UserResponse;
import com.adverbase.demo.repository.UserRepository;
import com.adverbase.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse save(UserRequset userRequset)
    {
        UserEntity userEntity =  new UserEntity();
        BeanUtils.copyProperties(userRequset,userEntity);
        userEntity.setPassword_hash(bCryptPasswordEncoder.encode(userRequset.getPassword()));

        UserEntity storedUser = userRepository.save(userEntity);

        UserResponse returnValue =  new UserResponse();
        BeanUtils.copyProperties(storedUser,returnValue);

        return returnValue;
    }

    @Override
    public boolean authenticate(LoginRequest loginRequest) {
       String pass = bCryptPasswordEncoder.encode(loginRequest.getPassword());
       userRepository.authenticate();
       return true;
    }
}
