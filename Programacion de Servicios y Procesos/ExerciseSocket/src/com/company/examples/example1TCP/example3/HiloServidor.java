package com.company.examples.example1TCP.example3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread {
    BufferedReader input;
    PrintWriter output;
    Socket socket = null;

    public HiloServidor(Socket socket) throws IOException {
        this.socket = socket;
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        String string = "";
        System.out.println("COMUNICO CON: " + socket.toString());

        while (!string.trim().equals("*")){
            try {
                string = input.readLine();
                output.println(string.toUpperCase());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("FIN CON: " + socket.toString());
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        output.close();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
