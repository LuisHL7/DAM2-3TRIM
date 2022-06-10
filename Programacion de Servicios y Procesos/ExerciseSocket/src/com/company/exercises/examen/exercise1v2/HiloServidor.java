package com.company.exercises.examen.exercise1v2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class HiloServidor extends Thread {
    DataInputStream input;
    DataOutputStream output;
    Socket client;
    private double num1;
    private double num2;
    private double resultado;
    private String operacion;

    public HiloServidor(Socket client) {
        this.client = client;
        try {
            output = new DataOutputStream(client.getOutputStream());
            input = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("ERROR DE E/S DE DATOS");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Cliente conectado:\n " +
                "IP: " + client.getInetAddress()
                + "\n Puerto: " + client.getPort());
        System.out.println("======================================");
        try {
            num1 = input.readDouble();
            num2 = input.readDouble();
            operacion = input.readUTF();

            switch (operacion) {
                case "*" -> resultado = num1 * num2;
                case "+" -> resultado = num1 + num2;
                case "-" -> resultado = num1 - num2;
                case "/" -> resultado = num1 / num2;
            }

            output.writeDouble(resultado);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Cliente desconectado:\n " +
                "IP: " + client.getInetAddress()
                + "\n Puerto: " + client.getPort());
        System.out.println("======================================");

        try {
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


