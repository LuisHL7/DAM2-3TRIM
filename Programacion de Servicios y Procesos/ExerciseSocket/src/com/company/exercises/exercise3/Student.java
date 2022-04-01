package com.company.exercises.exercise3;

public class Student {
    private String idStudent;
    private String name;
    private Course course;
    private int note;

    public Student() {
    }

    public Student(String idStudent, String name, Course course, int note) {
        this.idStudent = idStudent;
        this.name = name;
        this.course = course;
        this.note = note;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent='" + idStudent + '\'' +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", note=" + note +
                '}';
    }
}
