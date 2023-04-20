package com.highfive.tuto.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.highfive.tuto.domain.Brand;
import com.highfive.tuto.repositories.BrandRepository;

@Service
public class BrandService extends CrudService<Brand, Long> {
    
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository){
        super(brandRepository);
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand create(Brand brand){
        if (brandRepository.existsByName(brand.getName())) {
            throw new IllegalArgumentException("Brand '" + brand.getName() + "' already exists");
        }
        return super.create(brand);
    }

    public Optional<Brand> get(String name) {
        return brandRepository.findByName(name);
    }


}
