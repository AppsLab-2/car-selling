package com.carshop.repositories;

import com.carshop.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Brand findByName(String brandName);
}
