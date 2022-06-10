package com.company.exercises.exercise4;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class HiloServidor extends Thread {
    private Integer idClient;
    private Profesor[] teacherList;
    private Socket client = null;
    ObjectOutputStream output;
    DataInputStream input;


    public HiloServidor(int idClient, Profesor[] teacherList, Socket client) {
        this.idClient = idClient;
        this.teacherList = teacherList;
        this.client = client;
        try {
            output = new ObjectOutputStream(client.getOutputStream());
            input = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("ERROR DE E/S con cliente " + idClient);
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String code = "";
        //codigo socket
        try {
            output.writeObject(idClient);
        } catch (IOException e2) {
            System.out.println("ERROR AL ENVIAR IDCLIENTE CON CLIENTE " + idClient);
            e2.printStackTrace();
        }
        while (!code.trim().equals("*")) {
            //codigo profesor
            try {
                try {
                    code = input.readUTF();
                }catch(SocketException dd){
                    System.out.println("\tERROR AL LEER EL CLIENTE: "+idClient);
                    break;
                }catch (EOFException EO){
                    System.out.println("EL CLIENTE "+ idClient+" HA FINALIZADO ");
                    break;
                }

                System.out.println("\tSearching id: " + code + " by client " + idClient);
                output.reset();
                output.writeObject(searchTeacher(teacherList, Integer.parseInt(code)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("FIN CON: " + client.toString() + " DEL CLIENTE:  "+idClient);
        try {
            if (input != null) input.close();
            if (output != null) output.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static Profesor searchTeacher(Profesor[] teacher, int code) {
        Especialidad noexiste = new Especialidad(0, "sin datos");
        Profesor profesor = new Profesor(0, "No existe", null, noexiste);
        for (int i = 0; i < teacher.length; i++) {
            if (teacher[i].getIdProfesor() == code) {
                profesor = teacher[i];
            }
        }

        return profesor;
    }
}
