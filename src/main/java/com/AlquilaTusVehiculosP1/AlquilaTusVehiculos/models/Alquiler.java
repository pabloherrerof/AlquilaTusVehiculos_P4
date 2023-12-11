package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "alquileres")
public class Alquiler {
    @Id
    private String alquilerId;
    private String fechaInicio;
    private String fechaFin;
    private double importe;
    private String clienteId;
    private String vehiculoId;

    @Transient
    private Cliente cliente;

    // Getters y setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    @Transient
    private Vehiculo vehiculo;

    // Getters y setters
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    // Constructor, getters y setters

    public Alquiler() {
        // Constructor por defecto
    }

    public Alquiler(String fechaInicio, String fechaFin, double importe, String clienteId, String vehiculoId) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.importe = importe;
        this.clienteId = clienteId;
        this.vehiculoId = vehiculoId;
    }

    // Getters y setters

    public String getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(String vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getAlquilerId() {
        return alquilerId;
    }

    public void setAlquilerId(String alquilerId) {
        this.alquilerId = alquilerId;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
}
