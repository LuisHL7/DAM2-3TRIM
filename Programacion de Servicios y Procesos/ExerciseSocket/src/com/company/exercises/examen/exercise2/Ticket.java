package com.company.exercises.examen.exercise2;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String nombre;
    private String tipoEntrada;
    private double precio;

    public Ticket() {
    }

    private void llenarPrecio(String tipoEntrada) {
        switch (tipoEntrada) {
            case "Normal"-> precio = 10;
            case "Niños"-> precio = 3;
            case "Carnet Joven"-> precio = 5;
            case "Pensionista"-> precio = 4;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
        llenarPrecio(tipoEntrada);
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
