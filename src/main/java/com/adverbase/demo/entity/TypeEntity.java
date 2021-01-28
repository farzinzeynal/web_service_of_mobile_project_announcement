package com.adverbase.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "type")
@Data  // getter and setter
@NoArgsConstructor  // bos constructor
@AllArgsConstructor // dolu constructor
@ToString
@EqualsAndHashCode
public class TypeEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type_name",length = 400,unique = true)
    private String type_name;



}
