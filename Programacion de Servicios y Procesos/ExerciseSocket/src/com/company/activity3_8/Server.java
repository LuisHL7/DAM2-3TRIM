package com.company.activity3_8;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Waiting to datagram of client");

        byte[] dataReceived = new byte[1024];
        DatagramPacket received = new DatagramPacket(dataReceived, dataReceived.length);
        socket.receive(received);

        ByteArrayInputStream bais = new ByteArrayInputStream(dataReceived);
        ObjectInputStream input = new ObjectInputStream(bais);

        Person personRead = (Person) input.readObject();
        System.out.println("Persona recebida del cliente: " + personRead);

        Person person = new Person();
        person.setName("Jeff");
        person.setAge(19);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(baos);
        output.writeObject(person);

        byte[] bytes = baos.toByteArray();
        DatagramPacket sender = new DatagramPacket(bytes, bytes.length,received.getAddress(), received.getPort());
        socket.send(sender);
        System.out.println("Persona enviada al cliente: " + person);

        output.close();
        input.close();
        socket.close();


    }

}
