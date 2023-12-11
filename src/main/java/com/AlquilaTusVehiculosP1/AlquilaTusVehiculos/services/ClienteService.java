package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.services;

import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Cliente;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente obtenerClientePorId(String id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
