package com.example.rentACar.dataAccess.abstracts;


import com.example.rentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    // BrandDao
    Boolean existsByName(String name); // spring jpa keywords
}
