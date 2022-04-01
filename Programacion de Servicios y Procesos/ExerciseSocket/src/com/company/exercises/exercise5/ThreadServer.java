package com.company.exercises.exercise5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadServer extends Thread {
    BufferedReader input;
    PrintWriter output;
    Socket socket = null;

    public ThreadServer(Socket socket) throws IOException {
        this.socket = socket;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        String string = "";
        System.out.println("COMUNICO CON:" + socket.toString());
        while (!string.trim().equals("*")) {
            try {
                string = input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            output.println(string.trim().toUpperCase());
        }
        System.out.println("FIN CON: " + socket.toString());
        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

