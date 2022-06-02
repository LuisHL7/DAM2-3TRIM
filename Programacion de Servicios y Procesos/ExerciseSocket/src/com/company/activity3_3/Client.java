package com.company.activity3_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Program client started");
        Socket client = new Socket("localhost", 6000);

        DataInputStream input = new DataInputStream(client.getInputStream());
        String word = input.readUTF();
        System.out.println("Sending to server: \n\t " + word);

        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        output.writeUTF(word.toLowerCase());

        input.close();
        output.close();
        client.close();

    }
}
