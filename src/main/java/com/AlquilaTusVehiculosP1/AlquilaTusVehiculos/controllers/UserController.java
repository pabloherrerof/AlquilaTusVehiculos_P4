package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.controllers;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.User;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/register")
public class UserController{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping({"/", ""})
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", List.of("GESTOR", "USUARIO"));
        return "register";
    }

    @PostMapping({"/", ""})
    public String registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
