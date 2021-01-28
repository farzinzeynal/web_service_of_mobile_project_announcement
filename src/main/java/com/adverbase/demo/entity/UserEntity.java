package com.adverbase.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data  // getter and setter
@NoArgsConstructor  // bos constructor
@AllArgsConstructor // dolu constructor
@ToString
@EqualsAndHashCode
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name",length = 100,unique = true)
    private  String username;

    @Column(name = "password_hash",length = 200)
    private  String password_hash;

    @Column(name = "sure_name",length = 200)
    private  String  surename;

    @Column(name = "email",length = 200)
    private  String email;

    @Column(name = "phone_number",length = 200)
    private  String  phoneNumber;
}
