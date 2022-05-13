package com.company.compruebaTuAprendizaje.exercise4;

public class Especialidad {
    private int id;
    private String nombreEspe;
    private static int generarCodigo = 0;

    public Especialidad(String nombreEspe) {
        this.id = generarCodigo++;
        this.nombreEspe = nombreEspe;
    }
}
