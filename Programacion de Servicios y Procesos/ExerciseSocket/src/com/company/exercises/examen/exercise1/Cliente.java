package com.company.exercises.examen.exercise1;

import java.io.*;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        System.out.println("Program client started");
        Socket client = new Socket("localhost", 6001);

        BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));

        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());

        DataInputStream input = new DataInputStream(client.getInputStream());

        for (int i = 0; i < 4; i++) {
            Calculadora calculadora = new Calculadora();
            try {
                System.out.print("Ingrese el primer número: ");
                calculadora.setNum1(Double.parseDouble(entry.readLine()));
                System.out.print("Ingrese el segundo número: ");
                calculadora.setNum2(Double.parseDouble(entry.readLine()));
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número");
                break;
            }
            System.out.print("Ingrese la operación. Ex: SUMA, RESTA,  MULTIPLICACION O DIVISION: ");
            calculadora.setOperacion(entry.readLine());

            output.writeObject(calculadora);

            System.out.println("El resultado de la operación realizada es: " + input.readDouble());
            System.out.println("==================================================================");
        }

    }
}
