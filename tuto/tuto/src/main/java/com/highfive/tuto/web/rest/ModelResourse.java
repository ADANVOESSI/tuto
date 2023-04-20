package com.highfive.tuto.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;

import com.highfive.tuto.service.ModelService;
import com.highfive.tuto.domain.Model;



@RequestMapping("/models")

public class ModelResourse extends CrudResource<Model, Long> {
    
    private final ModelService modelService;
    
    public ModelResourse(ModelService modelService){
        super(modelService);
        this.modelService = modelService;
    }
}
