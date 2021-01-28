package com.adverbase.demo.repository;

import com.adverbase.demo.entity.AdverEntity;
import com.adverbase.demo.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity,Long>
{
    @Query(value = "SELECT * FROM TYPE ORDER BY id ", nativeQuery = true)
    List<TypeEntity> getAllAndOrderById();
}
