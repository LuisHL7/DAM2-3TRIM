package com.company.exercises.exercise4;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Asignatura implements Serializable {
    private int id;
    private String nombreAsignatura;


    public Asignatura() {
    }

    public Asignatura(int id, String nombreAsignatura) {
        this.id = id;
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


    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombreAsignatura='" + nombreAsignatura + '\'' +
                '}';
    }
}
