package com.adverbase.demo.serviceimpl;

import antlr.Utils;
import com.adverbase.demo.dto.AdverDto;
import com.adverbase.demo.entity.AdverEntity;
import com.adverbase.demo.entity.TypeEntity;
import com.adverbase.demo.entity.UserEntity;
import com.adverbase.demo.model.request.AdverRequset;
import com.adverbase.demo.model.response.AdverResponse;
import com.adverbase.demo.repository.AdverRepository;
import com.adverbase.demo.repository.TypeRepository;
import com.adverbase.demo.repository.UserRepository;
import com.adverbase.demo.service.AdverService;
import com.adverbase.demo.utils.Util;
import org.hibernate.type.DateType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdverServiceImpl implements AdverService
{
    @Autowired
    AdverRepository adverRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Util util;

    Date date;

    @Override
    public AdverResponse addAdver(AdverRequset request)
    {
        AdverEntity adverEntity =  new AdverEntity();
        BeanUtils.copyProperties(request, adverEntity);

        TypeEntity selectedType;
        UserEntity selectedUser;

        selectedType = typeRepository.getOne(request.getType_id());


        adverEntity.setAdver_number(util.generateAdverNumber(8));
        adverEntity.setAdver_type(selectedType);

        adverEntity.setAdver_date(new Date());
        adverEntity.setUpdated_at(new Date());

        AdverEntity storedAdver = adverRepository.save(adverEntity);

        AdverResponse returnDto = new AdverResponse();
        BeanUtils.copyProperties(storedAdver,returnDto);

        return returnDto;
    }

    @Override
    public AdverResponse update(Long id, AdverRequset adverRequset)
    {
        AdverResponse returnResponse = new AdverResponse();
        AdverEntity adverEntity = adverRepository.getOne(id);

        adverEntity.setAdver_name(adverRequset.getAdver_name());
        adverEntity.setAdver_price(adverRequset.getAdver_price());
        adverEntity.setType_id(adverRequset.getType_id());
        adverEntity.setAdver_city(adverRequset.getAdver_city());
        adverEntity.setUpdated_at(new Date());

        AdverEntity updatedAdver = adverRepository.save(adverEntity);
        BeanUtils.copyProperties(updatedAdver,returnResponse);

        return returnResponse;

    }

    @Override
    public AdverResponse addToLiked(Long id) {
        AdverResponse returnResponse = new AdverResponse();
        AdverEntity adverEntity = adverRepository.getOne(id);

        adverEntity.set_liked(true);

        AdverEntity updatedAdver = adverRepository.save(adverEntity);
        BeanUtils.copyProperties(updatedAdver,returnResponse);

        return returnResponse;
    }

    @Override
    public AdverResponse unLike(Long id) {
        AdverResponse returnResponse = new AdverResponse();
        AdverEntity adverEntity = adverRepository.getOne(id);

        adverEntity.set_liked(false);

        AdverEntity updatedAdver = adverRepository.save(adverEntity);
        BeanUtils.copyProperties(updatedAdver,returnResponse);

        return returnResponse;
    }


}
