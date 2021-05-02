package com.carshop.services;

import com.carshop.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getByUsername(String username);
    User addUser(User user);

}
