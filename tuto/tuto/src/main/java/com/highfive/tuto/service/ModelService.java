package com.highfive.tuto.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.highfive.tuto.domain.Brand;
import com.highfive.tuto.domain.Model;
import com.highfive.tuto.repositories.BrandRepository;
import com.highfive.tuto.repositories.ModelRepository;

@Service
public class ModelService extends CrudService<Model, Long> {
    
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelService(ModelRepository modelRepository, BrandRepository brandRepository){
        super(modelRepository);
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public Model create(Model model){
        Optional<Brand> brand = brandRepository.findByName(model.getBrand().getName());
        if (brand.isEmpty()) {
            throw new IllegalArgumentException("Brand with name '" + model.getBrand().getName()+ "'does not exist");
        }
        
        if (modelRepository.existsByNameAndBrand(model.getName(), brand.get())) {
            throw new IllegalArgumentException("Model'" + model.getName()+"'already exists for brand'" + model.getBrand().getName() + " .");
        }
        brand.get().getModels().add(model);
        brandRepository.save(brand.get());

        return modelRepository.findByNameAndBrand(model.getName(), brand.get()).get();
    }


}