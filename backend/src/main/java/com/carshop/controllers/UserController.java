package com.carshop.controllers;

import com.carshop.entities.Car;
import com.carshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("favorite")
    public Collection<Car> getFavoriteCars() {
        return this.userService.getFavoriteCars();
    }

    @PostMapping("addCarToFavorite")
    public void addCarToFavorites(@RequestBody int carId) {
        this.userService.addCarToFavorites(carId);
    }

    @DeleteMapping("removeCarFromFavorite")
    public void removeCarFromFavorites(@RequestBody int carId) {
        this.userService.removeCarFromFavorites(carId);
    }
}
