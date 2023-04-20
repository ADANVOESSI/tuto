package com.highfive.tuto.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.highfive.tuto.domain.Engine;
import com.highfive.tuto.domain.enums.EngineType;
import com.highfive.tuto.repositories.EngineRepository;

@Service
public class EngineService extends CrudService<Engine, Long> {
    
    private final EngineRepository engineRepository;

    public EngineService(EngineRepository engineRepository){
        super(engineRepository);
        this.engineRepository = engineRepository;
    }

    /**
     * @param engine
     * @return
     */
    @Override
    public Engine create(Engine engine){

        if (engineRepository.existsByNameAndType(engine.getName(), engine.getType())) {
            throw new IllegalArgumentException("Ce moteur'" + engine.getName() + "'  '" + engine.getType()+"' exists déjà");
        }
        return super.create(engine);
    }

    public Optional<Engine> getName(String name) {
        return engineRepository.findByName(name);
    }

    public Optional<Engine> get(String name, EngineType type) {
        return engineRepository.findByNameAndType(name, type);
    }

}

