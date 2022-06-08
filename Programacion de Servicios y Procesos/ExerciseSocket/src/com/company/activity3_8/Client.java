package com.company.activity3_8;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Program client started");
        DatagramSocket socket = new DatagramSocket();

        Person person = new Person();
        person.setName("Luis");
        person.setAge(27);
        System.out.println(person);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(baos);
        output.writeObject(person);

        byte[] bytes = baos.toByteArray();
        DatagramPacket sender = new DatagramPacket(bytes, bytes.length,InetAddress.getLocalHost(), 12345);
        socket.send(sender);

        byte[] dataReceived = new byte[1024];
        DatagramPacket received = new DatagramPacket(dataReceived, dataReceived.length);
        socket.receive(received);
        ByteArrayInputStream bais = new ByteArrayInputStream(dataReceived);
        ObjectInputStream input = new ObjectInputStream(bais);

        Person personRead = (Person) input.readObject();
        System.out.println("Persona recebida del server: " + personRead);

        output.close();
        input.close();
        socket.close();
    }
}

