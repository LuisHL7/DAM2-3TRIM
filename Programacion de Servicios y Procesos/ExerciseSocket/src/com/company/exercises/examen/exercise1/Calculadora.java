package com.company.exercises.examen.exercise1;

import java.io.Serializable;

public class Calculadora implements Serializable {
    private double num1;
    private double num2;
    private String operacion;

    public Calculadora() {
    }

    public Calculadora(double num1, double num2, String operacion) {
        this.num1 = num1;
        this.num2 = num2;
        this.operacion = operacion;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}
