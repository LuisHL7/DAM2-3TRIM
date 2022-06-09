package com.company.exercises.exercise4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidor extends Thread{
    private int id;
    private Profesor [] teacherList;
    private Socket client;

    public HiloServidor(int id, Profesor[] teacherList, Socket client) {
        this.id = id;
        this.teacherList = teacherList;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            DataOutputStream outputId = new DataOutputStream(client.getOutputStream());
            outputId.writeInt(id);

            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            int code = (int) input.readObject();

            System.out.println("Searching id: \n\t" + code + " by client " + id);

            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
            output.writeObject(searchTeacher(teacherList, code));

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }

    private static Profesor searchTeacher(Profesor[] teacher, int code ) {
        Profesor mr = null;
        for (int i = 0; i < teacher.length; i++) {
            if(teacher[i].getIdProfesor() == code){
                mr = teacher[i];
            }
        }
        if(mr == null){
            mr = new Profesor();
            mr.setIdProfesor(0);
            mr.setNombre("No existe");
        }

        return mr;
    }
}
