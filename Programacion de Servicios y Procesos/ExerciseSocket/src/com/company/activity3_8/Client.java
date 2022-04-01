package com.company.activity3_8;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Programa cliente iniciado:");
        Socket client = new Socket("localhost", 6000);
        byte[] dataRecieved = new byte[1024];
        Person person = new Person();
        person.setName("Luis");
        person.setAge(25);
        System.out.println();

//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream output = new ObjectOutputStream(baos);
//        output.writeObject(person);
//        output.close();
//        byte[] bytes = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(dataRecieved);
        ObjectInputStream input = new ObjectInputStream(bais);
        Person personRead = (Person) input.readObject();
        System.out.println("Persona recebida del server: " + personRead.toString());
        input.close();
    }
}

