package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes") // Define el nombre de la colección en MongoDB
public class Cliente {
    @Id
    private String clienteId;
    private String foto;
    private String nombre;
    private String email;
    private String telefono;



    public Cliente() {
        // Constructor por defecto
    }

    // Constructor con parámetros
    public Cliente( String nombre, String email, String telefono, String foto) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.foto = foto;
    }

    // Getters y setters

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
