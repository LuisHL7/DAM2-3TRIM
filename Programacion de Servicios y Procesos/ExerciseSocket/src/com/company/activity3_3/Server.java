package com.company.activity3_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting to client.....");
        Socket clientConnect = clientConnect =server.accept();

        //CREO FLUJO DE SALIDA AL CLIENTE
        DataOutputStream output = new DataOutputStream(clientConnect.getOutputStream());
        output.writeUTF("HELLO CLIENT FROM SERVER");

        //CREO FLUJO DE ENTRADA DEL CLIENTE
        DataInputStream input = new DataInputStream(clientConnect.getInputStream());
        System.out.println("Receiving from the client: \n\t" + input.readUTF());

        input.close();
        output.close();
        clientConnect.close();
        server.close();

    }
}
