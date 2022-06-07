package com.company.activity3_5.activity3_5v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Program client started");
        Socket client;
        try {
            client = new Socket("localhost", 6000);
        } catch (ConnectException e) {
            System.out.println("SERVER CLOSED. ");
            return;
        }

        DataInputStream input = new DataInputStream(client.getInputStream());
        System.out.println("Sending to server: \n\t " + input.readUTF());

        input.close();

        System.out.println("Closed client");
        client.close();

    }
}
