package com.company.exercises.examen.exercise2;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Program client started");
        Ticket ticket = new Ticket();

        System.out.print("Ingrese su nombre completo: ");
        ticket.setNombre(leerNombre());
        ticket.setTipoEntrada(elegirTicket());

        //Creandi socket
        DatagramSocket socket = new DatagramSocket();

        //Envió de datos
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(baos);
        output.writeObject(ticket);

        byte[] bytes = baos.toByteArray();
        DatagramPacket sender = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 12345);
        socket.send(sender);

        //Recepción de datos
        byte[] dataReceived = new byte[1024];
        DatagramPacket received = new DatagramPacket(dataReceived, dataReceived.length);
        socket.receive(received);

        ByteArrayInputStream bais = new ByteArrayInputStream(dataReceived);
        ObjectInputStream input = new ObjectInputStream(bais);

        Ticket ticket2 = (Ticket) input.readObject();

    }

    private static String elegirTicket() {
        String tipo = null;
        byte opcion;
        do {
            System.out.println("=======Tickets=======");
            System.out.println("1.-Normal: 10 ");
            System.out.println("2.-Niños: 3€ ");
            System.out.println("3.-Carnet Joven: 5€");
            System.out.println("4.-Pensionista: 4€ ");
            System.out.print("Elige una opción: ");
            opcion = leerOpcion();
            switch (opcion) {
                case 1 -> tipo = "Normal";
                case 2 -> tipo = "Niños";
                case 3 -> tipo = "Carnet Joven";
                case 4 -> tipo = "Pensionista";
                default -> System.out.println("Ingrese una opción válida");
            }
        } while (opcion > 4);
        return tipo;
    }

    protected static String leerNombre() {
        String name;
        boolean repeat;
        Scanner entry = new Scanner(System.in);
        do {
            repeat = true;
            name = entry.nextLine();
            if (!name.toUpperCase().matches("[A-ZÁÉÍÓÚÜÑ\\s]+")) {
                System.out.print("ERROR: El nombre ingresado es incorrecto name entered is incorrect. Enter a valid name:");
                repeat = false;
            }
        } while (!repeat);
        return name;
    }

    public static byte leerOpcion() {
        byte option = 0;
        boolean verify;
        Scanner entry = new Scanner(System.in);
        do {
            verify = true;
            if (entry.hasNextByte()) {
                option = entry.nextByte();
                if (option <= 0) {
                    System.out.println("ERROR: The value enter is negative. Write a positive number:");
                    verify = false;
                }
            } else {
                System.out.println("ERROR: The value enter is incorrectly. Write a number:");
                verify = false;
            }
            entry.nextLine();
        } while (!verify);
        return option;
    }

}
