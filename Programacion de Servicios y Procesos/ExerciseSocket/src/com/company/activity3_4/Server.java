package com.company.activity3_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting to client.....");
        Socket clientConnect =server.accept();

        DataInputStream input = new DataInputStream(clientConnect.getInputStream());
        int number = input.readInt();
        System.out.println("Receiving from the client: \n\t" + number);

        DataOutputStream output = new DataOutputStream(clientConnect.getOutputStream());
        output.writeInt(findingTheSquare(number));

        input.close();
        output.close();
        clientConnect.close();
        server.close();
    }

    private static int findingTheSquare(int number) {return (int) Math.pow(number,2);}

}
