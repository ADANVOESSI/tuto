package com.highfive.tuto.service;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.highfive.tuto.domain.Feature;
import com.highfive.tuto.repositories.FeatureRepository;

@Service
public class FeatureService extends CrudService<Feature, Long> {
    
    private final FeatureRepository featureRepository;

    public FeatureService(FeatureRepository featureRepository){
        super(featureRepository);
        this.featureRepository = featureRepository;
    }

    /**
     * @param feature
     * @return
     */
    @Override
    public Feature create(Feature feature){
        if (featureRepository.existsByName(feature.getName())) {
            throw new IllegalArgumentException("Cette option'" + feature.getName()+"' existe déjà");
        }
        return super.create(feature);
    }

    public Optional<Feature> getName(String name) {
        return featureRepository.findByName(name);
    }


}


