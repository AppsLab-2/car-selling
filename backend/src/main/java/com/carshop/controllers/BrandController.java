package com.carshop.controllers;

import com.carshop.entities.Brand;
import com.carshop.entities.Car;
import com.carshop.entities.Model;
import com.carshop.models.CarSearchRequest;
import com.carshop.repositories.BrandRepository;
import com.carshop.repositories.ModelRepository;
import com.carshop.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandRepository brandRepository;

    @GetMapping
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

    @GetMapping("{brandName}/models")
    public List<Model> getBrandModels(@PathVariable String brandName) {
        Brand brand = brandRepository.findByName(brandName);
        if(brand == null) {
            return new ArrayList<>();
        }
        return brand.getModels();
    }
}
