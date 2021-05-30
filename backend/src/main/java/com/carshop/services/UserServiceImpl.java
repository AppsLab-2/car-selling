package com.carshop.services;

import com.carshop.entities.Car;
import com.carshop.entities.User;
import com.carshop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CarService carService;

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void addCarToFavorites(int carId) {
        Optional<Car> optionalCar = this.carService.getCarById(carId);

        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            User user = this.getCurrentUser();

            user.getFavoriteCars()
                    .add(car);

            this.userRepository.save(user);
        }

    }

    @Override
    public void removeCarFromFavorites(int carId) {
        Optional<Car> optionalCar = this.carService.getCarById(carId);

        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            User user = this.getCurrentUser();

            user.getFavoriteCars()
                    .remove(car);

            this.userRepository.save(user);
        }
    }

    @Override
    public Collection<Car> getFavoriteCars() {
        return this.getCurrentUser().getFavoriteCars();
    }

    @Override
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getCurrentUser() {
        UserDetails user = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        String username = user.getUsername();
        return this.getByUsername(username)
                .orElseThrow(IllegalStateException::new);
    }
}
