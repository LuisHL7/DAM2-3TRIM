package com.company.exercises.exercise4;

import com.company.exercises.exercise3.Student;

import java.io.*;
import java.net.Socket;


/**
 * 1.-array de 5 objetos
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Program client started");
        Socket client = new Socket("localhost", 6001);

        BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream output = new DataOutputStream(client.getOutputStream());

        ObjectInputStream input = new ObjectInputStream(client.getInputStream());

        Integer code = (Integer) input.readObject();
        System.out.println("SOY EL CLIENTE: " + code);

        String id = "";
        Profesor teacher = new Profesor();
        do {
            System.out.println("=============================================================");
            System.out.print("Introduce identificador a consultar: ");
            id = entry.readLine();
            if (!id.trim().equals("*")) {
                //codigo profe
                output.writeUTF(id);

                //objeto profe
                teacher = (Profesor) input.readObject();

                System.out.println("Nombre: " + teacher.getNombre() + ", Especialidad: "
                        + teacher.getEspecialidad().getId() + " - " + teacher.getEspecialidad().getNombreEspe());

                try {
                    for (int i = 0; i < teacher.getAsignaturas().length; i++) {
                        System.out.println("Asignatura: " + teacher.getAsignaturas()[i].getId() + " - " + teacher.getAsignaturas()[i].getNombreAsignatura());
                    }
                } catch (java.lang.NullPointerException ignored) {

                }
            }
        } while (!id.trim().equals("*"));


        try {
            input.close();
            output.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
