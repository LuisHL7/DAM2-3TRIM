package com.company.activity3_5.activity3_5v2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number the clients: ");
        int numClient = scanner.nextInt();

        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting to client.....");

        for (int i = 1; i < numClient+1; i++) {
            Socket clientConnect = server.accept();
            DataOutputStream output = new DataOutputStream(clientConnect.getOutputStream());
            output.writeUTF("HELLO CLIENT " + i + " FROM SERVER");
            output.close();
            clientConnect.close();
        }

        System.out.println("Closed Server.");
        server.close();
    }


}
