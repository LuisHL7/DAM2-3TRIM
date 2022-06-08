package com.company.examples.example1TCP.example2;

import java.io.Serializable;

public class Persona implements Serializable {
    private String name;
    private int age;

    public Persona(String name, int edad) {
        this.name = name;
        this.age = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
