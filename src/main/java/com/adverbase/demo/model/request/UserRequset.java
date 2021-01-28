package com.adverbase.demo.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // getter and setter
@NoArgsConstructor  // bos constructor
@AllArgsConstructor // dolu constructor
public class UserRequset
{
    private  String username;
    private  String password;
    private  String surename;
    private  String email;
    private  String  phoneNumber;
}
