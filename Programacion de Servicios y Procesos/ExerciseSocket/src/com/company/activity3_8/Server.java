package com.company.activity3_8;

import java.io.*;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting the client");
        Socket client = server.accept();
        byte[] dataRecieved = new byte[1024];
        DatagramPacket packageRecieved = new DatagramPacket(dataRecieved,dataRecieved.length);
        MulticastSocket socket = new MulticastSocket(6000);
        socket.receive(packageRecieved);
        ByteArrayInputStream bais = new ByteArrayInputStream(dataRecieved);
        ObjectInputStream input = new ObjectInputStream(bais);
        Person person = (Person) input.readObject();
        System.out.println("Persona recebida del cliente: " + person.toString());
        person.setName("Juan");
        person.setAge(25);
        input.close();
//        //Send
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream output = new ObjectOutputStream(baos);
//        output.writeObject(person);
//        output.close();
//        byte[] bytes = baos.toByteArray();

    }

}
