package com.company.compruebaTuAprendizaje.exercise4;

public class Asignatura {
    private int id;
    private String nombreAsignatura;
    private static int generarCodigo = 0;

    public Asignatura(String nombreAsignatura) {
        this.id = generarCodigo++;
        this.nombreAsignatura = nombreAsignatura;
    }

}
