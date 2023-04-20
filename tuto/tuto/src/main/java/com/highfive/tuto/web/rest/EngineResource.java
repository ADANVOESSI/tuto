package com.highfive.tuto.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;

import com.highfive.tuto.service.EngineService;
import com.highfive.tuto.domain.Engine;



@RequestMapping("/engines")

public class EngineResource extends CrudResource<Engine, Long> {
    
    private final EngineService engineService;

    public EngineResource(EngineService engineService){
        super(engineService);
        this.engineService = engineService;
    }

}
