package com.company.examples.example1TCP.example3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6000);

        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));
        String line ="";
        do {
            System.out.print("Introduce una cadena: ");
            line = entry.readLine();

            output.println(line);
            System.out.println("=>ECO: " + input.readLine());
        } while (!line.trim().equals("*"));

        output.close();
        input.close();
        System.out.println("Fin del envió....");
        entry.close();
        socket.close();
    }
}
