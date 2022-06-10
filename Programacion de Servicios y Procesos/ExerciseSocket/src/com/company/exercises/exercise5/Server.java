package com.company.exercises.exercise5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(44444);
        System.out.println("Server started");
        while(true){
            Socket client = server.accept();
            ThreadServer thread = new ThreadServer(client);
            thread.start();
        }
    }
}
