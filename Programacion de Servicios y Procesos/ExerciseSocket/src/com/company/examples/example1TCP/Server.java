package com.company.examples.example1TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting to client");
        Socket client = server.accept();

        //Flujo de Entrada cliente con getInputStream()
        DataInputStream input = new DataInputStream(client.getInputStream());
        System.out.println("Receiving from the client: \n\t"+ input.readUTF());

        //Flujo de Salida al cliente con getOutputStream()
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        output.writeUTF("Hello client from server");

        //cerrar
        input.close();
        output.close();
        client.close();
        server.close();



    }
}
