package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.services;

import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Vehiculo;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public Vehiculo obtenerVehiculoPorId(String id) {
        return vehiculoRepository.findById(id).orElse(null);
    }
}