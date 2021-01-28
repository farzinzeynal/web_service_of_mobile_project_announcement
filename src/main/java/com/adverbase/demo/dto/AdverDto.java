package com.adverbase.demo.dto;

import com.adverbase.demo.entity.TypeEntity;
import com.adverbase.demo.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

@Data  // getter and setter
@NoArgsConstructor  // bos constructor
@AllArgsConstructor // dolu constructor
public class AdverDto implements Serializable
{
    private static final long serialVersionUID = 4865903039190150223L;

    private Long id;
    private String adver_name;
    private String adver_number;
    private String adver_price;
    private String adver_city;
    private String adver_detail;
    private boolean is_liked;
    private Date adver_date;
    private String adver_image;
    private Date updated_at;
    private TypeEntity adver_type;
    private String adver_owner_name;
    private String adver_owner_mail;
    private String adver_owner_phone;
    private  Long type_id;
}
