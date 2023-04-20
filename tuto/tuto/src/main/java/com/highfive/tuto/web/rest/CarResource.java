package com.highfive.tuto.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.highfive.tuto.service.CarService;
import com.highfive.tuto.domain.Car;

@RestController
@RequestMapping("/cars")

public class CarResource extends CrudResource<Car, Long> {
    
    private final CarService carService;
    public CarResource(CarService carService){
        super(carService);
        this.carService = carService;
    }
}
