package com.carshop.services;

import com.carshop.entities.Car;
import com.carshop.models.CarSearchRequest;
import com.carshop.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> searchCars(CarSearchRequest request) {
        List<Car> cars = new ArrayList<>();
        return cars;
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }
}
