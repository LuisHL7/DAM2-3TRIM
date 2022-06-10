package com.company.exercises.examen.exercise1Ar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {

            int puerto = 9999;
            Socket servidorSocket = new Socket("localhost", puerto);
            Scanner lector = new Scanner(System.in);

            OutputStream os = servidorSocket.getOutputStream();
            DataOutputStream salida = new DataOutputStream(os);

            InputStream is = servidorSocket.getInputStream();
            DataInputStream entrada = new DataInputStream(is);

            System.out.println("Conectado al Servidor de Calculo");


            System.out.println("Introduce el primer número");
            salida.writeDouble(escribirNumero(lector));
            System.out.println("Introduce un operador * / + - ");
            salida.writeUTF(escribirOperador(lector));
            System.out.println("Introduce segundo número");
            salida.writeDouble(escribirNumero(lector));
            System.out.println("[Servidor de Calculo]: " + entrada.readUTF());

            lector.close();
            entrada.close();
            salida.close();
            servidorSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static double escribirNumero(Scanner lector) {
        double numero = 0;
        boolean error;
        do {
            try {
                numero = Double.parseDouble(lector.nextLine());
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un numero");
                error = true;
            }
        } while (error);
        return numero;
    }

    public static String escribirOperador(Scanner lector) {
        String op= "";
        boolean error;
        do {
            op = lector.nextLine();
            switch(op) {
                case "*":
                case "/":
                case "+":
                case "-":
                    error = false;
                    break;
                default:
                    error = true;
            }
            if(error) {
                System.out.println("Operador incorrecto, debe ser * / + -");
            }
        } while (error);
        return op;
    }


}
