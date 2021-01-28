package com.adverbase.demo.controller;

import com.adverbase.demo.entity.TypeEntity;
import com.adverbase.demo.model.request.AdverRequset;
import com.adverbase.demo.model.request.TypeRequest;
import com.adverbase.demo.model.response.AdverResponse;
import com.adverbase.demo.repository.TypeRepository;
import com.adverbase.demo.utils.ApiPaths;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.TypePath.CTRL)
public class TypeController
{

    @Autowired
    TypeRepository typeRepository;

    @PostMapping
    public boolean createType (@Valid @RequestBody TypeRequest typeRequest)
    {
        TypeEntity typeEntity =  new TypeEntity();
        BeanUtils.copyProperties(typeRequest,typeEntity);

        ResponseEntity.ok(typeRepository.save(typeEntity));
        return true;
    }

    @GetMapping
    public List<TypeEntity> getAllType()
    {
       return typeRepository.getAllAndOrderById();
    }

}
