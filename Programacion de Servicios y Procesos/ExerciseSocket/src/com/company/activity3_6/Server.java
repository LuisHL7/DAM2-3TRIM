package com.company.activity3_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Waiting to datagram of client");
        String cadena = "";
        do {
            byte[] bufer = new byte[1024];
            DatagramPacket receive = new DatagramPacket(bufer, bufer.length);
            socket.receive(receive);
            cadena = new String(receive.getData()).trim();
            System.out.println("El servidor recibe: " + cadena);
            if(!cadena.equals("*")){
                InetAddress destino = receive.getAddress();
                byte[] buferEnvio = cadena.toUpperCase().getBytes();
                DatagramPacket send = new DatagramPacket(buferEnvio, buferEnvio.length, destino, receive.getPort());
                socket.send(send);
                System.out.println("Enviando cadena en mayúscula => : " +  new String(send.getData()).trim());
            }
        }while (!cadena.equals("*")) ;

        socket.close();
    }
}
