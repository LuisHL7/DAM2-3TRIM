package com.company.compruebaTuAprendizaje.exercise4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        creandoObjeos();

        int numeroPuerto = 6000;// Puerto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        String cad = "";

        System.out.println("Esperando conexion...");
        Socket Cliente = servidor.accept();
        System.out.println("Cliente conectado...");
    }

    private static void creandoObjeos() {
        Especialidad informatica = new Especialidad("Informática");
        Especialidad informatica = new Especialidad("Informática");

        Asignatura psp = new Asignatura("PSP");
        Asignatura di = new Asignatura("DI");
        Asignatura aad = new Asignatura("AAD");
        Asignatura pdmm = new Asignatura("PDMM");
        Asignatura sxe = new Asignatura("SXE");

        Profesor[] profesor = new Profesor[5];
        profesor[0] = new Profesor("Ester","Imagen Personal");
        profesor[1] = new Profesor("Luis",informatica);
        profesor[2] = new Profesor("Juan","Informática");
        profesor[3] = new Profesor("Marian","Imagen Personal");
        profesor[4] = new Profesor("Pepe","Informatica");
       
        
    }

}
