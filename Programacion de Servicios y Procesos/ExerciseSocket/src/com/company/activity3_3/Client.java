package com.company.activity3_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        int port = 6000;
        ServerSocket server = new ServerSocket(port);
        Socket clientConnect = null;
        System.out.println("Waiting th client");
        clientConnect = server.accept();

        //Input
        InputStream input = clientConnect.getInputStream();
        DataInputStream dataI = new DataInputStream(input);
        System.out.println("Recep the client: \n\t" + dataI.readUTF());

        //Output
        OutputStream output = clientConnect.getOutputStream();
        DataOutputStream dataO = new DataOutputStream(output);
        dataO.writeUTF("HELLO CLIENT");



    }
}
