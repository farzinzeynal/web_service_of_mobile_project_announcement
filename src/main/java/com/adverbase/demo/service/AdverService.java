package com.adverbase.demo.service;

import com.adverbase.demo.model.request.AdverRequset;
import com.adverbase.demo.model.response.AdverResponse;

public interface AdverService
{
      AdverResponse addAdver(AdverRequset request);

      AdverResponse update(Long id,AdverRequset adverRequset);

      AdverResponse addToLiked(Long id);

      AdverResponse unLike(Long id);

}
