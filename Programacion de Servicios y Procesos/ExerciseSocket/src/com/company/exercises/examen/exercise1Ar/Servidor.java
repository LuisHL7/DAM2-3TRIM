package com.company.exercises.examen.exercise1Ar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor;
            servidor = new ServerSocket(9999);
            System.out.println("Servidor de cálculo iniciado...");
            while(true) {
                Socket cliente = new Socket();
                cliente = servidor.accept();
                ServidorHilo hilo = new ServidorHilo(cliente);
                hilo.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


class ServidorHilo extends Thread{
    Socket cliente;

    double numero1 = 0;
    String op;
    double numero2 = 0;
    String resultado = "";

    DataInputStream entrada;
    DataOutputStream salida;
    OutputStream os;
    InputStream is;


    boolean fin = false;

    public ServidorHilo(Socket cliente) {
        this.cliente = cliente;
        System.out.println("Nuevo cliente ->  IP:" + cliente.getInetAddress() + " - Puerto:" + cliente.getPort());
    }

    @Override
    public void run() {
        try {
//			while(!fin) {
            is = cliente.getInputStream();
            entrada = new DataInputStream(is);

            numero1 = entrada.readDouble();
            op = entrada.readUTF();
            numero2 = entrada.readDouble();
            try {
                switch(op) {
                    case "*":
                        resultado = Double.toString(numero1 * numero2);
                        break;
                    case "/":
                        resultado = Double.toString(numero1 / numero2);
                        break;
                    case "+":
                        resultado =  Double.toString(numero1 + numero2);
                        break;
                    case "-":
                        resultado = Double.toString(numero1 - numero2);
                        break;
                    default:
                        throw new Exception();
                }
            }catch (Exception e) {
                resultado = "Error al realizar la operación";
            }

            os = cliente.getOutputStream();
            salida = new DataOutputStream(os);
            salida.writeUTF(resultado);
//			}
            System.out.println("Desconexión del cliente: " + cliente.getInetAddress() + " / " + cliente.getPort());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}