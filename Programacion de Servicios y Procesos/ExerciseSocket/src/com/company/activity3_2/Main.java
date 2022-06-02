package com.company.activity3_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Listening to: " + server.getLocalPort());

        Socket client1 = server.accept();
        System.out.println("Client 1 accept");
        System.out.println("Port Local: " + client1.getLocalPort());
        System.out.println("Port Remote: " + client1.getPort());
        client1.close();

        Socket client2 = server.accept();
        System.out.println("Client 2 accept");
        System.out.println("Port Local: " + client2.getLocalPort());
        System.out.println("Port Remote: " + client2.getPort());
        client2.close();
        server.close();





    }
}
