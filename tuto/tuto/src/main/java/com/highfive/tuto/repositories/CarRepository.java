package com.highfive.tuto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.highfive.tuto.domain.Car;
import com.highfive.tuto.domain.Model;

public interface CarRepository extends JpaRepository<Car, Long> {

    boolean existsByModelAndEngine_nameAndEngine_type(Model model, String name, String type);

}
