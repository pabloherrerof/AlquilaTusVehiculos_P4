package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehiculos")
public class Vehiculo {
    @Id private String vehiculoId;
    private String modelo;
    private String marca;
    private String matricula;
    private String color;

    private String foto;

    private String capacidad;


    // Constructor, getters y setters

    public Vehiculo() {
        // Constructor por defecto
    }

    public Vehiculo(String modelo, String marca, String matricula, String color, String foto, String capacidad) {
        this.modelo = modelo;
        this.marca = marca;
        this.matricula = matricula;
        this.color = color;
        this.foto = foto;
        this.capacidad = capacidad;
    }

    // Getters y setters

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
    public String getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(String vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFoto() {
    	return foto;
    }

    public void setFoto(String foto) {
    	this.foto = foto;
    }
}
