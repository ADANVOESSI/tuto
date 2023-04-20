package com.highfive.tuto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.highfive.tuto.domain.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    

}
