package com.company.examples.example1TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Program client started");
        Socket client = new Socket("localhost", 6000);

        //Flujo de Salida al server con getOutputStream()
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        output.writeUTF("Hello server from client");

        //Flujo de Entrada server con getInputStream()
        DataInputStream input = new DataInputStream(client.getInputStream());
        System.out.println("Receiving from the server: \n\t"+ input.readUTF());


        //cerrar
        input.close();
        output.close();
        client.close();
    }
}
