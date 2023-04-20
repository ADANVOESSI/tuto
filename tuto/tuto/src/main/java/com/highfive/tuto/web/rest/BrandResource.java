package com.highfive.tuto.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.highfive.tuto.service.BrandService;
import com.highfive.tuto.domain.Brand;


@RestController
@RequestMapping({"/brands"})

public class BrandResource extends CrudResource<Brand, Long> {
    
    private final BrandService brandService;

    public BrandResource(BrandService brandService){
        super(brandService);
        this.brandService = brandService;
    }
}
