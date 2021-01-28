package com.adverbase.demo.repository;

import com.adverbase.demo.entity.AdverEntity;
import com.adverbase.demo.entity.TypeEntity;
import com.adverbase.demo.model.response.AdverResponse;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdverRepository extends JpaRepository<AdverEntity,Long>
{

    @Query(value = "SELECT * FROM ADVERS WHERE TYPE_ID = ?1", nativeQuery = true)
    List<AdverEntity> findByType(Long TYPE_ID);


    @Query(value = "SELECT * FROM ADVERS WHERE is_liked = 1 ", nativeQuery = true)
    List<AdverEntity> getAllLikedAdver();



}
