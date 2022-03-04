package com.company.activity3_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        Socket clientConnect = null;
        System.out.println("Waiting to client.....");
        clientConnect =server.accept();

        //CREO FLUJO DE SALIDA AL CLIENTE
        DataOutputStream output = new DataOutputStream(clientConnect.getOutputStream());

        //ENVIO UN SALUDO AL CLIENTE
        output.writeUTF("SALUDOS AL CLIENTE DESDE EL SERVIDOR");

        //CREO FLUJO DE ENTRADA DEL CLIENTE
        DataInputStream input = new DataInputStream(clientConnect.getInputStream());

        //EL CLIENTE ME ENVÍA UN MENSAJE
        System.out.println("Recibiendo del cliente: \n\t" + input.readUTF());

        //CIERRA STREAMS Y SOCKETS

        input.close();
        output.close();
        clientConnect.close();
        server.close();


    }
}
