package com.highfive.tuto.service;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.highfive.tuto.domain.Customer;
import com.highfive.tuto.repositories.CustomerRepository;

@Service
public class CustomerService extends CrudService<Customer, Long> {
    
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public Customer create(Customer customer){
        if (customerRepository.existsByPhone(customer.getPhone())) {
            throw new IllegalArgumentException("Le numéro'" + customer.getName()+"'est déjà attribué à un client");
        }
        return super.create(customer);
    }

    public Optional<Customer> getPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

    public Optional<Customer> getName(String name) {
        return customerRepository.findByName(name);
    }


}
