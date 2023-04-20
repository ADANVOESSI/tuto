package com.highfive.tuto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.highfive.tuto.domain.Brand;
import com.highfive.tuto.domain.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
    
    //Model findByNameAndBrand_auteur(String name, String auteur);
    boolean existsByNameAndBrand(String name, Brand brand);

    Optional<Model> findByNameAndBrand(String name, Brand brand);
    
}
