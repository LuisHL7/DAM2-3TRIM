package com.company.exercises.examen.exercise1v2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        System.out.println("Program client started");
        Socket client = new Socket("localhost", 6001);

        DataOutputStream output = new DataOutputStream(client.getOutputStream());

        DataInputStream input = new DataInputStream(client.getInputStream());

        System.out.print("Ingrese el primer número: ");
        output.writeDouble(leerDouble());
        System.out.print("Ingrese el segundo número: ");
        output.writeDouble(leerDouble());
        System.out.print("Ingrese la operación (Ejm:*, +, -, /): ");
        output.writeUTF(leerOperacion());

        System.out.println("El resultado es: " + input.readDouble());

        output.close();
        input.close();
        client.close();
    }

    private static double leerDouble() {
            double value = 0;
            boolean repeat = true;
            Scanner entry = new Scanner(System.in);
            do {
                if (entry.hasNextDouble()) {
                    value = entry.nextDouble();
                    repeat = false;
                } else {
                    System.out.print("ERROR: El valor ingresado no es un número");
                }
                entry.nextLine();
            } while (repeat);

            return value;
        }

    private static String leerOperacion() {
        String code;
        boolean repeat;
        Scanner entry = new Scanner(System.in);
        do {
            repeat = true;
            code = entry.nextLine();
            if (!code.matches("[+*/-]")) {
                System.out.print("ERROR: El valor ingresado no es una operación. Solo puede ingresar estos valores (+,-,*,/)");
                repeat = false;
            }
        } while (!repeat);
        return code;
    }
}
