package com.company.exercises.exercise3;

import java.io.Serializable;

public class Course implements Serializable {
    private String id;
    private String description;


    public Course(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Course() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
