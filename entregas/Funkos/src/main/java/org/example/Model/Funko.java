package org.example.Model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data

public class Funko {
    private String cod;
    private String nombre;
    private String modelo;
    private Double precio;
    private LocalDate fecha;

    public Funko(String cod, String nombre, String modelo, Double precio, LocalDate fecha) {
        this.cod = cod;
        this.nombre = nombre;
        this.modelo = modelo;
        this.precio = precio;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Funko{" +
                "cod=" + cod +
                ", nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", fecha=" + fecha +
                '}';
    }
}