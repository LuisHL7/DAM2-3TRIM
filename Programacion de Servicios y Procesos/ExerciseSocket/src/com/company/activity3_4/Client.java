package com.company.activity3_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Program client started");
        Socket client = new Socket("localhost", 6000);

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        output.writeInt(scan.nextInt());

        DataInputStream input = new DataInputStream(client.getInputStream());
        System.out.println("The square is?: \n\t " + input.readInt());

        input.close();
        output.close();
        client.close();

    }
}
