package com.company.examples.example2UDP.example1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        InetAddress destino = InetAddress.getLocalHost();
        byte[] mensaje = new byte[1024];
        mensaje = "Enviando saludos".getBytes();

        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, 12345);
        DatagramSocket socket = new DatagramSocket(34567);

        System.out.println("Enviando datagrama de longitud " + mensaje.length);
        System.out.println("Host destino " + destino.getHostName());
        System.out.println("IP destino " + destino.getHostAddress());
        System.out.println("Puerto local del socket " + socket.getLocalPort());
        System.out.println("Puerto al que envió " + envio.getPort());

        socket.send(envio);
        socket.close();
    }
}
