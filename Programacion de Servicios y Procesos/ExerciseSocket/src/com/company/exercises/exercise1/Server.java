package com.company.exercises.exercise1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting to client.....");
        Socket clientConnect = server.accept();
        String string;
        DataInputStream input = new DataInputStream(clientConnect.getInputStream());
        DataOutputStream output = new DataOutputStream(clientConnect.getOutputStream());
        do {
            string = input.readUTF();
            if (!string.equals("*")) output.writeUTF("La cadena " + string + " tiene " + string.length() + " caracteres");
        } while (!string.equals("*")) ;

        input.close();
        output.close();
        clientConnect.close();
        System.out.println("Closed Server.");
        server.close();
    }
}
