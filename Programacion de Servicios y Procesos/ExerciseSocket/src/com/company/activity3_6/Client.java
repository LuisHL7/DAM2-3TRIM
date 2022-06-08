package com.company.activity3_6;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        MulticastSocket socket = new MulticastSocket(12345);
        InetAddress group = InetAddress.getByName("225.0.0.1");
        socket.joinGroup(group);

        String message = "";
        while (!message.trim().equals("*")) {
            byte[] buf = new byte[1024];
            DatagramPacket receive = new DatagramPacket(buf, buf.length);
            socket.receive(receive);
            message = new String(receive.getData());
            System.out.println("Recibo del servidor: " + message.trim());
        }
        System.out.println("Socket closed.");
        socket.leaveGroup(group);
        socket.close();
    }
}
