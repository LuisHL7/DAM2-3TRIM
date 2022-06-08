package com.company.activity3_7;

import com.company.examples.example1TCP.example2.Persona;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner entry = new Scanner(System.in);
        Socket client = null;
        try {
            client = new Socket("localhost", 6000);
            System.out.println("Program client started");
        } catch (ConnectException e) {
            System.out.println("ERROR AL ESTABLECER LA CONEXIÓN CON EL SERVIDOR....");
            System.exit(0);
        }

        ObjectOutputStream output;
        ObjectInputStream input = null;
        int num;
        do {
            System.out.print("Enter the number: ");
            num = entry.nextInt();
            Numbers numbers = new Numbers();
            numbers.setNumber(num);
            output = new ObjectOutputStream(client.getOutputStream());
            output.reset();
            output.writeObject(numbers);
            if(num > 0){
                input = new ObjectInputStream(client.getInputStream());
                Numbers number = (Numbers) input.readObject();
                System.out.println("Receiving from the server: \n\t" + "square: " +number.getSquare()  + " cube: " +number.getCube());
            }
        } while (num > 0);

        output.close();
        if(input != null){
            input.close();
        }
        client.close();
    }
}
