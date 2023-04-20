package com.highfive.tuto.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;

import com.highfive.tuto.service.FeatureService;
import com.highfive.tuto.domain.Feature;



@RequestMapping("/features")

public class FeatureResource extends CrudResource<Feature, Long> {
    
    private final FeatureService featureService;

    public FeatureResource(FeatureService featureService){
        super(featureService);
        this.featureService = featureService;
    }
}
