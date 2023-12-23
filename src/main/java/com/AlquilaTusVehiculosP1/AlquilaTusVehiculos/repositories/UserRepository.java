package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories;

import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

}
