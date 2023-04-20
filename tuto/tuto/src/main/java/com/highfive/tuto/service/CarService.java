package com.highfive.tuto.service;

import org.springframework.stereotype.Service;
import com.highfive.tuto.domain.Car;
import com.highfive.tuto.repositories.CarRepository;

@Service

public class CarService extends CrudService<Car, Long> {
    
    private final CarRepository carRepository;


    public CarService(CarRepository carRepository){
        super(carRepository);
        this.carRepository = carRepository;
    }

}