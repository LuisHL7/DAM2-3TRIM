package com.company.exercises.exercise3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMulticast {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> studentList = new ArrayList<>();
//        ServerSocket server = new ServerSocket(6000);
//        System.out.println("Waiting the client");
//        Socket client = server.accept();
        createdStudents(studentList);
//        searchStudent(studentList);

    }

    private static void searchStudent(ArrayList<Student> studentList, String id) {
        for (Student student : studentList){
            if(student.getIdStudent().equalsIgnoreCase(id)){
                System.out.println(student);
            }
        }
    }

    private static void createdStudents(ArrayList<Student> studentList) {
        Course dam = new Course("C1","DAM");
        Course asir = new Course("C2","ASIR");
        Course daw = new Course("C3","DAW");
        studentList.add(new Student("A1","Luis",dam,10));
        studentList.add(new Student("A2","Yole",asir,10));
        studentList.add(new Student("A3","Jonas",dam,10));
        studentList.add(new Student("A4","Jeff",daw,10));
        studentList.add(new Student("A5","Maria",asir,10));
    }
}
