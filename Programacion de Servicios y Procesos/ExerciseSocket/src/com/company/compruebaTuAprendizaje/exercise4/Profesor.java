package com.company.compruebaTuAprendizaje.exercise4;

public class Profesor {
    private int idProfesor;
    private String nombre;
    private Asignatura [] asignaturas;
    private Especialidad especialidad;
    private static int generarCodigo = 0;

    public Profesor(String nombre, Especialidad especialidad) {
        this.idProfesor = generarCodigo++;
        this.nombre = nombre;
        this.especialidad = especialidad;
        asignaturas = new Asignatura[3];
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
}
