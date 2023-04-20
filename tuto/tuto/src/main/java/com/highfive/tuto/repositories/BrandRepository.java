package com.highfive.tuto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.highfive.tuto.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    
    boolean existsByName(String name);

    // @Query("Select b from Brand b where b.name=?1")
    Optional<Brand> findByName(String name);
    
}
