package com.company.exercises.exercise5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",44444);
        PrintWriter output = new PrintWriter(client.getOutputStream(),true);
        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String string, eco = "";
        do {
            System.out.println("Insert string: ");
            string = in.readLine();
            output.println(string);
            eco = input.readLine();
            System.out.println("   =>ECO: " + eco);
        } while (!string.trim().equals("*"));
        output.close();
        input.close();
        System.out.println("Finished send....");
        in.close();
        client.close();
    }
}
