package com.adverbase.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data  // getter and setter
@NoArgsConstructor  // bos constructor
@AllArgsConstructor // dolu constructor
public class TypeDto implements Serializable
{
    private static final long serialVersionUID = 4865903039190150223L;

    private Long id;
    private String type_name;

}
