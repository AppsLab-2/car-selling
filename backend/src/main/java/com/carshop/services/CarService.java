package com.carshop.services;

import com.carshop.entities.Brand;
import com.carshop.entities.Car;
import com.carshop.models.CarSearchRequest;
import com.carshop.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> searchCars(CarSearchRequest request) {
        return carRepository.findAll(getQuerySpecification(request));
    }

    public Optional<Car> getCarById(int id) {
        return carRepository.findById(id);
    }
    
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    private Specification<Car> getQuerySpecification(
            CarSearchRequest example) {

        return (root, query, builder) -> {
            final List<Predicate> predicates = new ArrayList<>();

            // Brand
            if (example.getBrand() != null) {
                Join<Car, Brand> brandJoin = root.join("brand");
                predicates.add(builder.equal(builder.lower(brandJoin.get("id")), example.getBrand().getId()));
            }

            // Model
            if (example.getModel() != null) {
                Join<Car, Brand> modelJoin = root.join("model");
                predicates.add(builder.equal(builder.lower(modelJoin.get("id")), example.getModel().getId()));
            }

            // Price
            if (example.getMinPrice() != null) {
                predicates.add(builder.greaterThan(root.get("price"), example.getMinPrice()));
            }
            if (example.getMaxPrice() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("price"), example.getMaxPrice()));
            }

            // Registration year
            if (example.getMinRegistrationYear() != null) {
                predicates.add(builder.greaterThan(root.get("productionYear"), example.getMinRegistrationYear()));
            }
            if (example.getMaxRegistrationYear() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("productionYear"), example.getMaxRegistrationYear()));
            }

            // HP
            if (example.getMinHp() != null) {
                predicates.add(builder.greaterThan(root.get("productionYear"), example.getMinHp()));
            }
            if (example.getMaxHp() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("productionYear"), example.getMaxHp()));
            }

            // Fuel
            if (example.getFuel() != null) {
                predicates.add(builder.equal(root.get("fuel"), example.getFuel()));
            }

            // Transmission
            if (example.getTransmission() != null) {
                predicates.add(builder.equal(root.get("transmission"), example.getTransmission()));
            }

            // Type
            if (example.getType() != null) {
                predicates.add(builder.equal(root.get("type"), example.getType()));
            }

            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}
