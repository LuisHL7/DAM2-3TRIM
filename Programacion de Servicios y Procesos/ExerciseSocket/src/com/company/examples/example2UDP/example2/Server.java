package com.company.examples.example2UDP.example2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Server {
    public static void main(String[] args) throws IOException {
        InetAddress destino = InetAddress.getLocalHost();
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Waiting to datagram of client");

        byte[] bufer = new byte[1024];
        DatagramPacket receive = new DatagramPacket(bufer, bufer.length);
        socket.receive(receive);
        String cadena = new String(receive.getData()).trim();
        System.out.println("El servidor recibe: " + cadena);
        int count = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if(cadena.charAt(i) == 'a') {
                count++;
            }
        }

        byte[] buferEnvio = (String.valueOf(count)).getBytes();
        DatagramPacket send = new DatagramPacket(buferEnvio, buferEnvio.length, destino, 34567);
        socket.send(send);
        System.out.println("Enviando número de apariciones de la letra a => : " +  new String(send.getData()).trim());
        socket.close();
    }
}
