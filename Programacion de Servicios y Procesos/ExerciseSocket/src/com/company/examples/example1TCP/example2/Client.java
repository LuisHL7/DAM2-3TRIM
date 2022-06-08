package com.company.examples.example1TCP.example2;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Program client started");
        Socket client = new Socket("localhost", 6000);

        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        Persona personInput = (Persona) input.readObject();
        System.out.println("Receiving from the client: \n\t" + personInput.getName() + " " + personInput.getAge());

        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        personInput.setName("Luis");
        personInput.setAge(30);
        output.writeObject(personInput);

        System.out.println("Sending from the server: \n\t" + personInput.getName() + " " + personInput.getAge());

        input.close();
        output.close();
        client.close();
    }
}
