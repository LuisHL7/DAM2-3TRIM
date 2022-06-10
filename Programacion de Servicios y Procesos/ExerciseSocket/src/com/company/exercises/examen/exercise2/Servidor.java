package com.company.exercises.examen.exercise2;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Waiting to datagram of client");

        while (true) {
            //Recepción de datos
            byte[] dataReceived = new byte[1024];
            DatagramPacket received = new DatagramPacket(dataReceived, dataReceived.length);
            socket.receive(received);

            ByteArrayInputStream bais = new ByteArrayInputStream(dataReceived);
            ObjectInputStream input = new ObjectInputStream(bais);

            Ticket ticket = (Ticket) input.readObject();
            System.out.println("Visitante: " + ticket.getNombre() +
                        "\nTIPO DE ENTRADA: " + ticket.getTipoEntrada() +
                        "\nA PAGAR: " + ticket.getPrecio());
            System.out.println("================================================");

            //Envió de datos
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(baos);
            output.writeObject(ticket);

            byte[] bytes = baos.toByteArray();
            DatagramPacket sender = new DatagramPacket(bytes, bytes.length, received.getAddress(), received.getPort());
            socket.send(sender);

        }

    }
}
