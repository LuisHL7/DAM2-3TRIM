package com.company.examples.example2UDP.example2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class Server {
    public static void main(String[] args) throws IOException {
        byte[] bufer = new byte[1024];
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Waiting to datagram of client");
        DatagramPacket receive = new DatagramPacket(bufer, bufer.length);
        socket.receive(receive);
        String cadena = new String(receive.getData()).trim();
        System.out.println("El servidor recibe: " + cadena);
        int cantidad = cadena.indexOf("a");
        System.out.println("Enviando número de apariciones de la letra a =>t : " + cadena);
        socket.close();
    }
}
