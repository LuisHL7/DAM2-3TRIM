package com.company.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class Example2UrlCon {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost/2018/vernombre.php");
            URLConnection conection = url.openConnection();
            conection.setDoOutput(true);
            String string = "nombre=Maria Jesús&apellidos=Ramos Martín";

            //Writer to URL
            PrintWriter output = new PrintWriter(conection.getOutputStream());
            output.write(string);
            output.close();

            //Read to URL
            BufferedReader input = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
