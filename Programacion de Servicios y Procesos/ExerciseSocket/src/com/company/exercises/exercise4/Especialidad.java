package com.company.exercises.exercise4;

import java.io.Serializable;

public class Especialidad implements Serializable {
    private int id;
    private String nombreEspe;


    public Especialidad() {

    }

    public Especialidad(int id, String nombreEspe) {
        this.id = id;
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


    @Override
    public String toString() {
        return "Especialidad{" +
                "id=" + id +
                ", nombreEspe='" + nombreEspe + '\'' +
                '}';
    }
}
