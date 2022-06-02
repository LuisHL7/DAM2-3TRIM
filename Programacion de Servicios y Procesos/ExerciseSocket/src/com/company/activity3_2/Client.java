package com.company.activity3_2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 6000);

        System.out.println("Port Local: " + client.getLocalPort());
        System.out.println("Port Remote: " + client.getPort());
        System.out.println("Name Host/IP: " + client.getInetAddress());

        client.close();
    }
}
