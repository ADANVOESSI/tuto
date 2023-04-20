package com.highfive.tuto.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.highfive.tuto.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    
    boolean existsByPhone(String phone);

    Optional<Customer> findByName(String name);

    Optional<Customer> findByPhone(String phone);
}

