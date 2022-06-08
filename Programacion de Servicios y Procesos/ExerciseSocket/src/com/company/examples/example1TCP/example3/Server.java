package com.company.examples.example1TCP.example3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server stared.");

        while (true) {
            Socket socket = server.accept();
            HiloServidor hilo = new HiloServidor(socket);
            hilo.start();
        }

    }
}
