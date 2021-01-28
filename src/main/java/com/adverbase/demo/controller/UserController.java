package com.adverbase.demo.controller;

import com.adverbase.demo.entity.UserEntity;
import com.adverbase.demo.model.request.AdverRequset;
import com.adverbase.demo.model.request.LoginRequest;
import com.adverbase.demo.model.request.UserRequset;
import com.adverbase.demo.model.response.AdverResponse;
import com.adverbase.demo.model.response.LoginResponse;
import com.adverbase.demo.model.response.UserResponse;
import com.adverbase.demo.repository.UserRepository;
import com.adverbase.demo.serviceimpl.JwtUserDetailsService;
import com.adverbase.demo.serviceimpl.UserServiceImpl;
import com.adverbase.demo.utils.ApiPaths;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.UserPath.CTRL)
public class UserController
{

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepository userRepository;



    @PostMapping
    ResponseEntity<UserResponse> createUser (@Valid @RequestBody UserRequset userRequset)
    {
        return ResponseEntity.ok(userServiceImpl.save(userRequset));
    }


    @GetMapping
    List<UserEntity> getAllUsers ()
    {
       return userRepository.findAll();
    }




    /* @PostMapping(value = "/authenticate")
    public ResponseEntity<LoginResponse> createAuthentication(@RequestBody LoginRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        UserEntity user = userRepository.findByUsername(authenticationRequest.getUsername());
        return ResponseEntity.ok(new LoginResponse(user.getUsername(),user.getSurename()));
    }*/

}
