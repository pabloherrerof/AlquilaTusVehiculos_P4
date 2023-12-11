package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
