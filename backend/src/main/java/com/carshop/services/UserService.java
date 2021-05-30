package com.carshop.services;

import com.carshop.entities.Car;
import com.carshop.entities.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    Optional<User> getByUsername(String username);
    void addCarToFavorites(int carId);
    void removeCarFromFavorites(int carId);
    Collection<Car> getFavoriteCars();
    User addUser(User user);
    User getCurrentUser();
}
