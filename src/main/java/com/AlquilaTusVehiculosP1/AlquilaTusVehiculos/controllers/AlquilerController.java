package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.controllers;

import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Alquiler;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Cliente;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.User;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Vehiculo;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.AlquilerRepository;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.ClienteRepository;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.UserRepository;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.VehiculoRepository;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.services.ClienteService;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping({"/gestor/alquileres", "/usuarios/alquileres", "/api/alquileres"})
public class AlquilerController {


    @Autowired
    private final AlquilerRepository alquilerRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private VehiculoService vehiculoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private ClienteRepository clienteRepository;







    public AlquilerController(AlquilerRepository alquilerRepository, UserRepository userRepository, VehiculoRepository vehiculoRepository, ClienteRepository clienteRepository) {
        this.alquilerRepository = alquilerRepository;
        this.userRepository = userRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.clienteRepository  = clienteRepository;
    }

    @GetMapping({"", "/"})
    public String listarAlquileres(Model model, Authentication authentication) {
        List<Alquiler> listaAlquileres;
        List<Vehiculo> listaVehiculos;

        listaVehiculos = vehiculoRepository.findAll();
        boolean esGestor = authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_GESTOR"));

        if (esGestor) {
            // Si es gestor, obtiene todos los alquileres sin restricciones
            listaAlquileres = alquilerRepository.findAll();
        } else {
            // Si es usuario, obtiene los alquileres con el clienteId del usuario actual
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String userName = userDetails.getUsername();
            String clienteId = userRepository.findByUsername(userName).get().getClienteId();
            if(clienteId != null){
                listaAlquileres = alquilerRepository.findByClienteId(clienteId);;
            } else {
                listaAlquileres = null;
            }

        }


        model.addAttribute("paginaActiva", "alquileres"); // Agrega el nombre de la página activa
        model.addAttribute("listaAlquileres", listaAlquileres);
        model.addAttribute("listaVehiculos", listaVehiculos);
        return "alquileres";
    }



    @PostMapping({"", "/"})
    public String crearAlquiler(@ModelAttribute Alquiler alquiler, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String userName = userDetails.getUsername();
        User user = userRepository.findByUsername(userName).get();
        String clienteId = userRepository.findByUsername(userName).get().getClienteId();


        alquilerRepository.findByClienteId(clienteId);
        if(clienteId == null || clienteId.isEmpty()){
            Cliente cliente = new Cliente(user.getName(), user.getUsername(),"none", "https://t4.ftcdn.net/jpg/02/32/44/81/240_F_232448172_R1bkR8CNR2PWIcFesZRiIA1yt2ZmOP2f.jpg");
            clienteRepository.save(cliente);
            Cliente clienteCreado =clienteRepository.findByEmail(user.getUsername());
            alquiler.setClienteId(clienteCreado.getClienteId());
            user.setClienteId(clienteCreado.getClienteId());
            userRepository.save(user);
        } else {
            alquiler.setClienteId(clienteId);
        }
        System.out.println("clienteId: " + clienteId);

        alquilerRepository.save(alquiler);
        return "redirect:/usuarios/alquileres";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Alquiler obtenerAlquiler(@PathVariable String id) {
        return alquilerRepository.findById(id).orElse(null);
    }

    @PreAuthorize("hasRole('USUARIO')")
    @PutMapping("/{id}")
    @ResponseBody
    public Alquiler actualizarAlquiler(@PathVariable String id, @RequestBody Alquiler alquiler) {
        alquiler.setAlquilerId(id);
        return alquilerRepository.save(alquiler);
    }
    @PreAuthorize("hasRole('USUARIO')")
    @DeleteMapping("/{id}")
    @ResponseBody
    public void eliminarAlquiler(@PathVariable String id) {
        alquilerRepository.deleteById(id);
    }
}

