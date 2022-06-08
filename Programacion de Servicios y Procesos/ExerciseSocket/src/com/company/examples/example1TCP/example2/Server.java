package com.company.examples.example1TCP.example2;

import com.company.activity3_8.Person;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting to client");
        Socket client = server.accept();

        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        Persona personOutput = new Persona("Juan", 20);
        output.writeObject(personOutput);
        System.out.println("Sending from the client: \n\t" + personOutput.getName() + " " + personOutput.getAge());

        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        Persona personInput = (Persona) input.readObject();
        System.out.println("Receiving from the client: \n\t" + personInput.getName() + " " + personInput.getAge());

        output.close();
        input.close();
        client.close();
        server.close();


    }
}
