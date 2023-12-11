package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.controllers;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Cliente;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private final ClienteRepository clienteRepository;
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    @GetMapping({"", "/"})
    public String listarClientes(Model model) {
        List<Cliente> listaClientes = clienteRepository.findAll();
        model.addAttribute("paginaActiva", "clientes"); // Agrega el nombre de la página activa
        model.addAttribute("listaClientes", listaClientes);

        return "clientes";
    }

    @PostMapping({"", "/"})
    public String crearCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Cliente obtenerCliente(@PathVariable String id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @PostMapping("/update/{id}")
    public String actualizarCliente(@PathVariable String id, @ModelAttribute Cliente cliente) {
        cliente.setClienteId(id);
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @PostMapping("/delete/{id}")
    public String eliminarCliente(@PathVariable String id) {

        clienteRepository.deleteById(id);
        return "redirect:/clientes";
    }
}
