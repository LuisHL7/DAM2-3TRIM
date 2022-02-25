package com.company.activity3_2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 6000;

        Socket client = new Socket(host, port);

        InetAddress address = client.getInetAddress();
        System.out.println("Port Local: " + client.getLocalPort());
        System.out.println("Port Remote: " + client.getPort());
        System.out.println("Name Host/IP: " + client.getInetAddress());
        System.out.println("Host Remote: " + address.getHostName().toString());
        System.out.println("IP Host Remote: " + address.getHostAddress().toString());

        client.close();
    }
}
