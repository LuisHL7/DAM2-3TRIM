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
        System.out.println("Ingrese una cadena: ");

        byte[] mensaje = entry.nextLine().getBytes();
        DatagramSocket socket = new DatagramSocket(34567);
        DatagramPacket send = new DatagramPacket(mensaje, mensaje.length, destino, 12345);
        socket.send(send);

        System.out.println("Waiting datagram");
        byte[] mensajeRecibido = new byte [1024];
        DatagramPacket receive = new DatagramPacket(mensajeRecibido, mensajeRecibido.length);
        socket.receive(receive);
        String cantidad = new String(receive.getData()).trim();
        System.out.println("Recibo nº de caracteres que son: " + cantidad);
        socket.close();
    }
}
