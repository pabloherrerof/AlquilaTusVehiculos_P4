package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.controllers;

import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Alquiler;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Cliente;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Vehiculo;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.AlquilerRepository;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.VehiculoRepository;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.services.ClienteService;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping("/alquileres")
public class AlquilerController {


    @Autowired
    private final AlquilerRepository alquilerRepository;
    @Autowired
    private VehiculoService vehiculoService;
    @Autowired
    private ClienteService clienteService;


    public AlquilerController(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    @GetMapping({"", "/"})
    public String listarAlquileres(Model model) {
        List<Alquiler> listaAlquileres = alquilerRepository.findAll();
        listaAlquileres.forEach(alquiler -> {
            Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(alquiler.getVehiculoId());
            alquiler.setVehiculo(vehiculo);
            Cliente cliente = clienteService.obtenerClientePorId(alquiler.getClienteId());
            alquiler.setCliente(cliente);
        });
        System.out.println(listaAlquileres);
        model.addAttribute("paginaActiva", "alquileres"); // Agrega el nombre de la página activa
        model.addAttribute("listaAlquileres", listaAlquileres);
        return "alquileres";
    }

    @PostMapping({"", "/"})
    public Alquiler crearAlquiler() {
        Alquiler alquiler = new Alquiler("2021/05/01", "2021-05-02", 100, "655bb31a13869209aa2eb46f", "655bb2e713869209aa2eb468");
        return alquilerRepository.save(alquiler);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Alquiler obtenerAlquiler(@PathVariable String id) {
        return alquilerRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Alquiler actualizarAlquiler(@PathVariable String id, @RequestBody Alquiler alquiler) {
        alquiler.setAlquilerId(id);
        return alquilerRepository.save(alquiler);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void eliminarAlquiler(@PathVariable String id) {
        alquilerRepository.deleteById(id);
    }
}

