package com.carshop.controllers;

import com.carshop.entities.Brand;
import com.carshop.entities.Car;
import com.carshop.models.CarSearchRequest;
import com.carshop.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<Car> getCars() {
        return carService.getAll();
    }

    @PostMapping(value = "search")
    public List<Car> searchCars(@RequestBody CarSearchRequest request) {
        return carService.searchCars(request);
    }
}
