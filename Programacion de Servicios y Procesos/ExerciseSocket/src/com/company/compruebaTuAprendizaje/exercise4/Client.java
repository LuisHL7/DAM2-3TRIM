package com.company.compruebaTuAprendizaje.exercise4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1.-array de 5 objetos
 */
public class Client {
    public static void main(String[] args) throws IOException {

        String Host = "localhost";
        int Puerto = 6000;// puerto remoto
        Socket Cliente = new Socket(Host, Puerto);

        // CREO FLUJO DE SALIDA AL SERVIDOR
        OutputStream salida = null;
        salida = Cliente.getOutputStream();
        DataOutputStream fsalida = new DataOutputStream(salida);

        // CREO FLUJO DE ENTRADA DE SERVIDOR
        InputStream entrada = null;
        entrada = Cliente.getInputStream();

        DataInputStream flujoEntrada = new DataInputStream(entrada);

        String cadena;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce cadena: ");
    }
}
