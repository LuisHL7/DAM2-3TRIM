package com.company.exercises.exercise3;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ServerUDP {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> studentList = new ArrayList<>();
        createdStudents(studentList);

        DatagramSocket socket = new DatagramSocket(6001);
        System.out.println("Waiting to datagram of client");

        ObjectOutputStream output = null;
        String code = "";
        while (!code.equals("*")) {
            byte[] dataReceived = new byte[1024];
            DatagramPacket received = new DatagramPacket(dataReceived, dataReceived.length);
            socket.receive(received);
            code = new String(received.getData()).trim();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            output = new ObjectOutputStream(baos);
            output.writeObject(searchStudent(studentList, code));

            byte[] bytes = baos.toByteArray();
            DatagramPacket sender = new DatagramPacket(bytes, bytes.length, received.getAddress(), received.getPort());
            socket.send(sender);
        }

        output.close();
        socket.close();

    }

    private static Student searchStudent(ArrayList<Student> studentList, String id) {
        Student studentData = null;
        for (Student student : studentList) {
            if (student.getIdStudent().equalsIgnoreCase(id)) {
                studentData = student;
            }
        }
        if (studentData == null) {
            Course notData= new Course("*","Sin Datos");
            studentData = new Student(id, "Sin Datos", notData, -1);
        }
        return studentData;
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
