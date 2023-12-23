package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.HashSet;

@Document
public class User {

    @Id
    private String id;
    private String username;
    private String name;
    private String password;
    private Collection<String> roles;
    private String clienteId;

    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String id, String username, String password, Collection<String> roles, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.name = name;
    }
    public User(String id, String username, String password, Collection<String> roles, String clienteId, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.clienteId = clienteId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String usuarioId) {
        this.clienteId = usuarioId;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

    // Método para agregar un rol
    public void addRole(String role) {
        if (this.roles == null) {
            this.roles = new HashSet<>();
        }
        this.roles.add(role);
    }

    // Método para eliminar un rol
    public void removeRole(String role) {
        if (this.roles != null) {
            this.roles.remove(role);
        }
    }

    // Método toString para representar el objeto como una cadena
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
