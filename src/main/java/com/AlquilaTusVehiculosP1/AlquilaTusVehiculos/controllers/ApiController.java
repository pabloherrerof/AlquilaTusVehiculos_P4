package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.controllers;


import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Alquiler;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Cliente;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.User;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Vehiculo;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.AlquilerRepository;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.ClienteRepository;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/api"})
public class ApiController {
    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AlquilerRepository alquilerRepository;


    public ApiController(AlquilerRepository alquilerRepository, VehiculoRepository vehiculoRepository, ClienteRepository clienteRepository) {
        this.alquilerRepository = alquilerRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.clienteRepository  = clienteRepository;

    }

    @GetMapping("/alquiler")
    @ResponseBody
    public List<Alquiler> obtenerAlquileres() {
        return alquilerRepository.findAll();
    }

    @GetMapping("/vehiculos")
    @ResponseBody
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculoRepository.findAll();
    }

    @GetMapping("/clientes")
    @ResponseBody
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping("/alquiler")
    @ResponseBody
    public Alquiler crearAlquiler(@RequestBody Alquiler alquiler) {
        return alquilerRepository.save(alquiler);
    }

    @PostMapping("/vehiculos")
    @ResponseBody
    public Vehiculo crearVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
}
