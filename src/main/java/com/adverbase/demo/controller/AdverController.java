package com.adverbase.demo.controller;


import com.adverbase.demo.entity.AdverEntity;
import com.adverbase.demo.model.request.AdverRequset;
import com.adverbase.demo.model.response.AdverResponse;
import com.adverbase.demo.repository.AdverRepository;
import com.adverbase.demo.serviceimpl.AdverServiceImpl;
import com.adverbase.demo.utils.ApiPaths;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.AdverPath.CTRL)
public class AdverController
{


    @Autowired
    AdverServiceImpl adverServiceImpl;

    @Autowired
    AdverRepository adverRepository;

    @PostMapping
    public ResponseEntity<AdverResponse> createAdver (@Valid @RequestBody AdverRequset adverRequset)
    {
        return ResponseEntity.ok(adverServiceImpl.addAdver(adverRequset));
    }

    @GetMapping
    public List<AdverEntity> getAllAdver ()
    {
        return adverRepository.findAll();
    }

    @GetMapping("/getAllByType/{type_id}")
    public List<AdverEntity> getAllByType (@PathVariable Long type_id)
    {
        return adverRepository.findByType(type_id);
    }

    @GetMapping("/getAllLiked")
    public List<AdverEntity> getAllByType ()
    {
        return adverRepository.getAllLikedAdver();
    }


    @GetMapping("/{id}")
    public ResponseEntity<AdverEntity> getOne (@PathVariable Long id)
    {
        return ResponseEntity.ok(adverRepository.getOne(id));
    }


    @PutMapping (path = "/update/{id}")
    public  ResponseEntity<AdverResponse> updateUser(@PathVariable Long id, @RequestBody AdverRequset adverRequset)
    {
        return ResponseEntity.ok(adverServiceImpl.update(id,adverRequset));
    }

    @PutMapping (path = "/addToLiked/{id}")
    public  ResponseEntity<AdverResponse> addToLiked(@PathVariable Long id)
    {
        return ResponseEntity.ok(adverServiceImpl.addToLiked(id));
    }

    @PutMapping (path = "/unLikeAdver/{id}")
    public  ResponseEntity<AdverResponse> unLikeAdver(@PathVariable Long id)
    {
        return ResponseEntity.ok(adverServiceImpl.unLike(id));
    }


}
