package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories;

import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Vehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehiculoRepository extends MongoRepository<Vehiculo, String> {
    // Puedes agregar métodos personalizados si necesitas consultas específicas
}