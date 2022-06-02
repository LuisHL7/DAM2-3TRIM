package com.company.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Example2Url {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://www.elaltozano.es");
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(url != null ? url.openStream() : null));
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                in.close();
            } catch (IOException e){
                e.printStackTrace();
            }
    }
}
