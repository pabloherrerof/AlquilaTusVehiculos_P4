package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories;

import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Alquiler;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlquilerRepository extends MongoRepository<Alquiler, String> {

}
