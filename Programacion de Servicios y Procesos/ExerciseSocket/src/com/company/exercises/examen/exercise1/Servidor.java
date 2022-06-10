package com.company.exercises.examen.exercise1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6001);
        System.out.println("Server started.");

        while (true) {
            Socket client = server.accept();
            HiloServidor hilo = new HiloServidor(client);
            hilo.start();

        }
    }
}
