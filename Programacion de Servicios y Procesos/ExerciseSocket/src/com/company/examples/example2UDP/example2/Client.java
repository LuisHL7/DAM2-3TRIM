package com.company.examples.example2UDP.example2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner entry = new Scanner(System.in);
        InetAddress destino = InetAddress.getLocalHost();
        byte[] mensaje = entry.nextLine().getBytes();

        DatagramSocket socket = new DatagramSocket(34567);
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, 12345);
        socket.send(envio);
        socket.close();
    }
}
