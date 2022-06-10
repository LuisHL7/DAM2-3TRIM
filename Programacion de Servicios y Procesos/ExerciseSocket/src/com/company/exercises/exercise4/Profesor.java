package com.company.exercises.exercise4;

import java.io.Serializable;
import java.util.Arrays;

public class Profesor implements Serializable {
    private int idProfesor;
    private String nombre;
    private Asignatura[] asignaturas;
    private Especialidad especialidad;


    public Profesor() {
    }

    public Profesor(int idProfesor, String nombre, Asignatura[] asignaturas, Especialidad especialidad) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
        this.especialidad = especialidad;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignatura[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "idProfesor=" + idProfesor +
                ", nombre='" + nombre + '\'' +
                ", asignaturas=" + Arrays.toString(asignaturas) +
                ", especialidad=" + especialidad +
                '}';
    }
}
