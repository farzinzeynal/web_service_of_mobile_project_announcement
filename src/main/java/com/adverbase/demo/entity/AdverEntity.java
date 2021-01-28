package com.adverbase.demo.entity;


import com.adverbase.demo.dto.TypeDto;
import com.adverbase.demo.dto.UserDto;
import lombok.*;

import javax.persistence.*;
import java.awt.*;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

@Entity
@Table(name = "advers")
@Data  // getter and setter
@NoArgsConstructor  // bos constructor
@AllArgsConstructor // dolu constructor
@ToString
@EqualsAndHashCode
public class AdverEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "adver_name",length = 400)
    private String adver_name;

    @Column(name = "adver_number",length = 400,unique = true)
    private String adver_number;

    @Column(name = "adver_price",length = 400)
    private String adver_price;

    @Column(name = "adver_city",length = 400)
    private String adver_city;

    @Column(name = "adver_detail",length = 400)
    private String adver_detail;

    @Column(name = "is_liked")
    private boolean is_liked;

    @Column(name = "adver_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adver_date;


    @Lob
    @Column(name = "adver_image")
    private String adver_image;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @JoinColumn(name = "avder_type")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    TypeEntity adver_type;

    @Column(name = "adver_owner_name",length = 400)
    private String adver_owner_name;

    @Column(name = "adver_owner_mail",length = 400)
    private String adver_owner_mail;

    @Column(name = "adver_owner_phone",length = 400)
    private String adver_owner_phone;

    @Column(name = "type_id")
    private  Long type_id;


}
