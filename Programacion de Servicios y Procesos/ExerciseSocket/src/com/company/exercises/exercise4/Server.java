package com.company.exercises.exercise4;

import com.company.examples.example1TCP.example2.Persona;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Profesor[] teacherList = new Profesor[5];
        createdObjects(teacherList);
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started.");
        String cad = "";
        int id = 0;
        while (true) {
            id++;
            System.out.println("Waiting to client");
            Socket client = server.accept();
            System.out.println("Client" + id + "connected");
            HiloServidor hilo = new HiloServidor(id,teacherList, client);
            hilo.start();

        }

    }


    private static void createdObjects(Profesor[] teacher ) {
        Especialidad informatica = new Especialidad("Informática");
        Especialidad matematica = new Especialidad(2, "MATEMÁTICAS");
        Especialidad idioma = new Especialidad "LENGUAS");

        Asignatura[] asignatura1 = new Asignatura[4];
        asignatura1[0] = new Asignatura("PSP");
        asignatura1[1] = new Asignatura("DI");
        asignatura1[2] = new Asignatura("AAD");
        asignatura1[3] = new Asignatura("PDMM");

        Asignatura[] asignatura2 = new Asignatura[4];
        asignatura1[1] = new Asignatura("Matemáticas I");
        asignatura1[0] = new Asignatura("Matemáticas II");
        asignatura1[2] = new Asignatura("Matemáticas III");
        asignatura1[3] = new Asignatura( "Matemáticas IV");

        Asignatura[] asignatura3 = new Asignatura[4];
        asignatura1[0] = new Asignatura("INGLÉS");
        asignatura1[1] = new Asignatura( "FRANCÉS");
        asignatura1[2] = new Asignatura( "ALEMAN");
        asignatura1[3] =  new Asignatura( "MANDARÍN");

        teacher[0] = new Profesor("Ester",asignatura1, informatica);
        teacher[1] = new Profesor("Luis",asignatura2, matematica);
        teacher[2] = new Profesor("Juan", asignatura3, idioma);
        teacher[3] = new Profesor("Marian",asignatura1, informatica);
        teacher[4] = new Profesor("Pepe",asignatura3, idioma);

    }

}
