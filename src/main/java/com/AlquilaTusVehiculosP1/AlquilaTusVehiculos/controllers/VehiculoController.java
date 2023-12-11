package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.controllers;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Vehiculo;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    private final VehiculoRepository vehiculoRepository;

    public VehiculoController(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @GetMapping({"", "/"})
    public String listarVehiculos(Model model) {
        List<Vehiculo> listaVehiculos = vehiculoRepository.findAll();
        model.addAttribute("paginaActiva", "vehiculos"); // Agrega el nombre de la página activa
        model.addAttribute("listaVehiculos", listaVehiculos);
        return "vehiculos";
    }

    @PostMapping({"", "/"})
    public String crearVehiculo(@ModelAttribute Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);

        return "redirect:/vehiculos";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Vehiculo obtenerVehiculo(@PathVariable String id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    @PostMapping("/update/{id}")
    public String actualizarVehiculo(@PathVariable String id, @ModelAttribute Vehiculo vehiculo) {
        vehiculo.setVehiculoId(id);
        vehiculoRepository.save(vehiculo);
        return "redirect:/vehiculos";
    }

    @PostMapping("/delete/{id}")
    public String eliminarVehiculo(@PathVariable String id) {
        vehiculoRepository.deleteById(id);
        return "redirect:/vehiculos";
    }
}


