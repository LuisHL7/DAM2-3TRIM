package com.company.exercises.examen.exercise1;

import java.io.*;
import java.net.Socket;

public class HiloServidor extends Thread {
    private Socket client;
    DataOutputStream output;
    ObjectInputStream input;

    public HiloServidor(Socket client) {
        this.client = client;
        try {
            output = new DataOutputStream(client.getOutputStream());
            input = new ObjectInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("ERROR DE E/S DE DATOS");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <4 ; i++) {
                //Recibo objeto con números y operación a realizar
                Calculadora calculadora = (Calculadora) input.readObject();
                System.out.println("Se recibió del cliente:\n" +
                        "num 1 = " + calculadora.getNum1() +
                        "\nnum 2 = " + calculadora.getNum2() +
                        "\noperación  = " + calculadora.getOperacion());
                System.out.println("===========================================================");
                //Envió resultado
                output.writeDouble(hallarOperacion(calculadora));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private double hallarOperacion(Calculadora calculadora) {
        double resultado = 0;
        if(calculadora.getOperacion().equalsIgnoreCase("suma")) resultado = calculadora.getNum1() + calculadora.getNum2();
        else if (calculadora.getOperacion().equalsIgnoreCase("resta")) resultado = calculadora.getNum1() - calculadora.getNum2();
        else if (calculadora.getOperacion().equalsIgnoreCase("multiplicacion")) resultado = calculadora.getNum1() * calculadora.getNum2();
        else if (calculadora.getOperacion().equalsIgnoreCase("division")) resultado = calculadora.getNum1() / calculadora.getNum2();
        else System.out.println("La operación ingresada no existe.");
        return resultado;
    }


}
