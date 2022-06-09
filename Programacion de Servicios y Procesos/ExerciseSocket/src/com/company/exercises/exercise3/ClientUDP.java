package com.company.exercises.exercise3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner entry = new Scanner(System.in);

        DatagramSocket socket = new DatagramSocket();
        ObjectInputStream input = null;
        String code = "";

        while (!code.equals("*")) {
            System.out.print("Ingrese el código del alumno: ");
            code = entry.nextLine();
            byte[] mensaje = code.getBytes();

            DatagramPacket send = new DatagramPacket(mensaje, mensaje.length, InetAddress.getLocalHost(), 6001);
            socket.send(send);

            byte[] dataReceived = new byte[1024];
            DatagramPacket received = new DatagramPacket(dataReceived, dataReceived.length);
            socket.receive(received);
            ByteArrayInputStream bais = new ByteArrayInputStream(dataReceived);
            input = new ObjectInputStream(bais);

            Student student = (Student) input.readObject();
            System.out.println("Persona recebida del server: " + student);
        }

        input.close();
        socket.close();


    }
}
