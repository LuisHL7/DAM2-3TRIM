package com.company.exercises.exercise4;

import java.io.Serializable;

public class Asignatura implements Serializable {
    private int id;
    private String nombreAsignatura;
    private static int generarCodigo = 0;

    public Asignatura(String nombreAsignatura) {
        this.id = generarCodigo++;
        this.nombreAsignatura = nombreAsignatura;
    }

    public int getId() {
        return id;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public static int getGenerarCodigo() {
        return generarCodigo;
    }

    public static void setGenerarCodigo(int generarCodigo) {
        Asignatura.generarCodigo = generarCodigo;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombreAsignatura='" + nombreAsignatura + '\'' +
                '}';
    }
}
