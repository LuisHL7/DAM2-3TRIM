package com.company.activity3_7;

import com.company.examples.example1TCP.example2.Persona;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting to client");
        Socket client = server.accept();

        ObjectOutputStream output = null;
        ObjectInputStream input = null;
        Numbers num = null;
        do {
            try {
                input = new ObjectInputStream(client.getInputStream());
                num = (Numbers) input.readObject();
                System.out.println("Receiving from the client: \n\t" + "number: " + num.getNumber());
            } catch (SocketException ce) {
                System.out.println("ERROR AL RECIBIR DATOS DEL CLIENTE...." + ce.getMessage());
                System.exit(0);

            }
            if (num.getNumber() > 0) {
                Numbers numbers = new Numbers();
                numbers.setSquare((long) Math.pow(num.getNumber(), 2));
                numbers.setCube((long) Math.pow(num.getNumber(), 3));
                output = new ObjectOutputStream(client.getOutputStream());
                output.reset();
                output.writeObject(numbers);
                System.out.println("Sending from the client: \n\t" + "square:" + numbers.getSquare() + " cube: " + numbers.getCube());
            }
        } while (num.getNumber() > 0);

        input.close();
        if (output != null) {
            output.close();
        }
        client.close();
        server.close();


    }
}
