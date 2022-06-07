package com.company.examples.example2UDP.example1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class Server {
    public static void main(String[] args) throws IOException {
        byte[] bufer = new byte[1024];
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Waiting to datagram");
        DatagramPacket receive = new DatagramPacket(bufer, bufer.length);
        socket.receive(receive);

        //View information
        System.out.println("Number of bytes receive " + receive.getLength());
        System.out.println("Content from package " + new String(receive.getData()).trim());
        System.out.println("Port origen from message: " + receive.getPort());
        System.out.println("Ip de origen " + receive.getAddress().getHostAddress());
        System.out.println("Puerto destino del mensaje " + socket.getLocalPort());

        socket.close();
    }
}
