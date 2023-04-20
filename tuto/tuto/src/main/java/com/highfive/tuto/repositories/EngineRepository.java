package com.highfive.tuto.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

// import com.highfive.tuto.domain.Car;
import com.highfive.tuto.domain.Engine;
import com.highfive.tuto.domain.enums.EngineType;


public interface EngineRepository extends JpaRepository<Engine,Long>{

    boolean existsByNameAndType(String name, EngineType type);

    Optional<Engine> findByName(String name);
    Optional<Engine> findByNameAndType(String name, EngineType type);

}

