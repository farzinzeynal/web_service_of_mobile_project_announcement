package com.adverbase.demo.model.request;

import com.adverbase.demo.entity.TypeEntity;
import com.adverbase.demo.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Clob;
import java.util.Date;

@Data  // getter and setter
@NoArgsConstructor  // bos constructor
@AllArgsConstructor // dolu constructor
public class AdverRequset
{
    private String adver_name;
    private String adver_price;
    private String adver_image;
    private String adver_city;
    private String adver_detail;
    private String adver_owner_name;
    private String adver_owner_mail;
    private String adver_owner_phone;
    private  Long type_id;
}
