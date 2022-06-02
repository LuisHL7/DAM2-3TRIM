package com.company.exercises.exercise1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Program client started");
        Socket clientConnect = new Socket("localhost", 6000);
        Scanner scanner = new Scanner(System.in);
        String string;
        DataOutputStream output;
        DataInputStream input = null;
        do {
            System.out.print("Enter the string: ");
            string = scanner.nextLine();
            output = new DataOutputStream(clientConnect.getOutputStream());
            output.writeUTF(string);
            if(!string.equals("*")){
                input = new DataInputStream(clientConnect.getInputStream());
                System.out.println("Sending to server: \n\t " + input.readUTF());
            }

        } while (!string.equals("*"));
        output.close();
        if(input != null){
            input.close();
        }
        System.out.println("Closed client");
        clientConnect.close();
    }
}
