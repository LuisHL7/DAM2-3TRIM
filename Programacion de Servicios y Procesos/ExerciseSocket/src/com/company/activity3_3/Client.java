package com.company.activity3_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {


        System.out.println("Programa cliente iniciado");
        Socket client = new Socket("localhost", 6000);

        //CREO FLUJO DE ENTRADA AL SERVIDOR
        DataInputStream input = new DataInputStream(client.getInputStream());
        String word = input.readUTF();
//        //EL SERVIDOR ME ENVIA UN MENSAJE
      System.out.println("Sending to server: \n\t " + word);

        // CREO FLUJO DE ENTRADA AL SERVIDOR
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        //ENVIÓ UN SALUDO AL SERVIDOR
        output.writeUTF(word.toLowerCase());



        //CERRAR STREAMS Y SOCKETS
        input.close();
        output.close();
        client.close();

    }
}
