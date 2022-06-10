package com.company.exercises.exercise4;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static Profesor teacherList[] = new Profesor[5];
    public static void main(String[] args) throws IOException{
        createdObjects();
        ServerSocket server = new ServerSocket(6001);
        System.out.println("Server started.");

        int id = 0;
        while (true) {
            id++;
            Socket client = server.accept();
            System.out.println("Client " + id + " connected");
            HiloServidor hilo = new HiloServidor(id,teacherList, client);
            hilo.start();

        }
    }

    private static void createdObjects() {
        Asignatura asi1 = new Asignatura(1,"PSP");
        Asignatura asi2 = new Asignatura(2,"DI");
        Asignatura asi3 = new Asignatura(3,"AAD");
        Asignatura asi4 = new Asignatura(4,"PDMM");

        Asignatura asi5 = new Asignatura(5,"Matemáticas I");
        Asignatura asi6 = new Asignatura(6,"Matemáticas II");
        Asignatura asi7 = new Asignatura(7,"Matemáticas III");
        Asignatura asi8 = new Asignatura( 8,"Matemáticas IV");

        Asignatura asi9 =  new Asignatura(9,"INGLÉS");
        Asignatura asi10 = new Asignatura( 10,"FRANCÉS");
        Asignatura asi11 = new Asignatura( 11,"ALEMAN");
        Asignatura asi12 = new Asignatura( 12,"MANDARÍN");

        Especialidad informatica = new Especialidad(1,"INFORMÁTICA");
        Especialidad matematica = new Especialidad( 2,"MATEMÁTICAS");
        Especialidad idioma = new Especialidad( 3,"LENGUAS");

        Asignatura[] asignatura1 = new Asignatura[4];
        asignatura1[0] = asi1;
        asignatura1[1] = asi2;
        asignatura1[2] = asi3;
        asignatura1[3] = asi4;

        Profesor profesor4 = new Profesor(1,"Marian",asignatura1, informatica);


        Asignatura[] asignatura2 = new Asignatura[4];
        asignatura2[0] = asi5;
        asignatura2[1] = asi6;
        asignatura2[2] = asi7;
        asignatura2[3] = asi8;

        Profesor profesor1 = new Profesor(2,"Ester",asignatura2, informatica);
        Profesor profesor2 = new Profesor(3,"Luis",asignatura2, matematica);

        Asignatura[] asignatura3 = new Asignatura[4];
        asignatura3[0] = asi9 ;
        asignatura3[1] = asi10;
        asignatura3[2] = asi11;
        asignatura3[3] = asi12;

        Profesor profesor3 = new Profesor(4,"Juan", asignatura3, idioma);
        Profesor profesor5 = new Profesor(5,"Pepe",asignatura3, idioma);

        teacherList[0] = profesor1;
        teacherList[1] = profesor2;
        teacherList[2] = profesor3;
        teacherList[3] = profesor4;
        teacherList[4] = profesor5;

    }

}
