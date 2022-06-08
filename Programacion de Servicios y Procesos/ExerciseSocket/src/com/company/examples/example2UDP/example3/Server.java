package com.company.examples.example2UDP.example3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;


public class Server {
    public static void main(String[] args) throws IOException {
        Scanner entry = new Scanner(System.in);
        MulticastSocket socket = new MulticastSocket();
        InetAddress destino = InetAddress.getByName("225.0.0.1");

        System.out.println("Ingrese una cadena: ");
        String cadena = "";

        while (!cadena.equals("*")) {
            System.out.print("Datos a a enviar al grupo: ");
            cadena = entry.nextLine();
            DatagramPacket send = new DatagramPacket(cadena.getBytes(), cadena.length(), destino, 12345);
            socket.send(send);
        }

        socket.close();
        System.out.println("Socket cerrado");
    }
}

