package com.company.exercises.exercise4;

import java.io.Serializable;

public class Especialidad implements Serializable {
    private int id;
    private String nombreEspe;
    private static int generarCodigo = 0;



    public Especialidad(String nombreEspe) {
        this.id = generarCodigo++;
        this.nombreEspe = nombreEspe;
    }

    public int getId() {
        return id;
    }

    public String getNombreEspe() {
        return nombreEspe;
    }

    public void setNombreEspe(String nombreEspe) {
        this.nombreEspe = nombreEspe;
    }

    public static int getGenerarCodigo() {
        return generarCodigo;
    }

    public static void setGenerarCodigo(int generarCodigo) {
        Especialidad.generarCodigo = generarCodigo;
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "id=" + id +
                ", nombreEspe='" + nombreEspe + '\'' +
                '}';
    }
}
