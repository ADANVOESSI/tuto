package com.highfive.tuto;

import com.highfive.tuto.config.ApplicationProperties;
import com.highfive.tuto.domain.Car;
import com.highfive.tuto.domain.Engine;
import com.highfive.tuto.domain.enums.EngineType;
import com.highfive.tuto.service.*;

import ch.qos.logback.core.model.Model;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
@Service

public class HelloWorldService {
    
    private final BrandService brandService;
    private final ModelService modelService;
    private final CarService carService;
    private final EngineService engineService;
    private final FeatureService featureService;
    

    public HelloWorldService(ApplicationProperties applicationProperties, 
    BrandService brandService, ModelService modelService, CarService carService, EngineService engineService, FeatureService featureService, CustomerService customerService, SaleService saleService) {

        this.brandService = brandService;
        this.modelService = modelService;
        this.carService = carService;
        this.engineService = engineService;
        this.featureService = featureService;

        System.out.println(applicationProperties.getHello());
    }

    @Transactional
    public void test(){
        //Insert Engine

        Engine bmwEngine = new Engine();
        bmwEngine.setName("iX1 xDrive30");
        bmwEngine.setType(EngineType.ELECTRIC);
        bmwEngine = engineService.create(bmwEngine);

        //Si le model exits déjà en base et que je ne dois pas le créer
        Model bmwModel = new Model();
        bmwModel = modelService.get("iX");

        //Si l'Engine existe déjà en base

        Engine bmwEngine2 = new Engine();
        bmwEngine2 = engineService.get("iX1 xDrive30", EngineType.ELECTRIC);

        //Insert Car

        Car bmwCar = new Car();
        bmwCar.setModel(bmwModel);
        bmwCar.setPrice(BigDecimal.valueOf(55000));
        bmwCar.getEngine().add(bmwEngine);
        carService.create(bmwCar);

        printCars();

    }

    @Transactional

    public void printCars(){
        carService.getAll().stream().collect(Collectors.groupingBy(car -> car.getModel().getName())).forEach((brand, cars) -> {
            System.out.println(brand);
            cars.forEach(car -> {
                System.out.println("\t" + car.getModel().getName() + " " + car.getPrice() + "€");
                car.getEngine().forEach(engine -> {
                    System.out.println("\t\t" + engine.getName() + "(" + engine.getType() + ")");
                });
            });
        });
    }
}
