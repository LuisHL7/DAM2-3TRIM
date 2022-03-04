package com.company.activity3_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {


        System.out.println("Programa cliente iniciado");
        Socket client = new Socket("localhost", 6000);

        // CREO FLUJO DE ENTRADA AL SERVIDOR
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = scan.nextInt();
        //send a number to server
        output.writeInt(number);

        //CREO FLUJO DE ENTRADA AL SERVIDOR
        DataInputStream input = new DataInputStream(client.getInputStream());
       //EL SERVIDOR ME ENVIA UN MENSAJE
        System.out.println("Sending to server: \n\t " + input.readInt());



        //CERRAR STREAMS Y SOCKETS
        input.close();
        output.close();
        client.close();

    }
}
