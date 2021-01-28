package com.adverbase.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // getter and setter
@NoArgsConstructor  // bos constructor
@AllArgsConstructor // dolu constructor
public class UserResponse
{
    private Long id;
    private  String username;
    private  String surename;
    private  String email;
    private  String  phoneNumber;
}
