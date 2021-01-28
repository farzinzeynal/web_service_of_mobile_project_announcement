package com.adverbase.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // getter and setter
@NoArgsConstructor  // bos constructor
@AllArgsConstructor // dolu constructor
public class TypeRequest
{
    private String type_name;
}
