package com.highfive.tuto.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.highfive.tuto.service.CustomerService;
import com.highfive.tuto.domain.Customer;


@RestController
@RequestMapping("/customers")
public class CustomerResource extends CrudResource<Customer, Long>{
    
    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService){
        super(customerService);
        this.customerService = customerService;
    }

}
