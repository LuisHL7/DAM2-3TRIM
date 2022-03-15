/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author mrnov
 */

import clases.Jugadores;
import clases.Paises;

import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import java.math.BigDecimal;
import java.math.BigInteger;

//Principal 
public class Actividad1_Main {//CREACIÓN Y LLENADO DE BD

//Creacion y relleno de las clases en la bd db4o

    public static void main(String[] args) {
        //Instancias de paises para almacenar en la DB:
        Paises pais1 = new Paises(1, "España");
        Paises pais2 = new Paises(2, "Italia");
        Paises pais3 = new Paises(3, "Suiza");
        Paises pais4 = new Paises(4, "EEUU");
        //instancias de jugadores para almacenar en BD
        Jugadores j1 = new Jugadores("Maria", "voleibol", pais1, 14);
        Jugadores j2 = new Jugadores("Miguel", "tenis", pais2, 15);
        Jugadores j3 = new Jugadores("Mario", "baloncesto", pais3, 15);
        Jugadores j4 = new Jugadores("Alicia", "tenis", pais4, 14);
    /*La conexión la realizo con un objeto de clase ODB,
    en la que indico la ruta donde tengo la base de datos.
    Esto sirve para abrirla como para crear una nueva*/
//    ODB odb = ODBFactory.open("C:\\bds\\EQUIPOS.DB");

        ODB odb = ODBFactory.open("EQUIPOS.DB");
        //Almaceno los objetos en la BD
//        odb.store(j1);
//        odb.store(j2);
//        odb.store(j3);
//        odb.store(j4);

        //recupero todos los objetos
        Objects objectsJug = odb.getObjects(Jugadores.class);
        // Genero un conjunto de objetos y los traigo del ODB conectado
        // Objects<Jugadores> objectsJug=odb.getObjects(Jugadores.class);

        System.out.println("Hay " + objectsJug.size() + " Jugadores en la BD:");

        // JUGADORES
        int i = 1; //contador para mostrar listados los objetos

        //visualizar los objetos Jugador
        while (objectsJug.hasNext()) {
            // Creo un objeto Jugadores y almaceno ahí el objeto que recupero de la BD
            Jugadores jug = (Jugadores) objectsJug.next();
            // Imprimo las propiedades que me interesan de ese objeto
            System.out.println((i++) + " - " + "Nombre: " + jug.getNombre() + ", Deporte: " + jug.getDeporte() + ", Pais: " + jug.getPais().getNombrePais() + ", Edad: " + jug.getEdad());
        }

        //recupero todos los objetos Paises de la BD
        Objects objectsPaises = odb.getObjects(Paises.class);

        System.out.println("Hay " + objectsPaises.size() + " Paises en la BD:");

        //PAISES
        int j = 1; //contador para mostrar listados los objetos
        //visualizar los objetos
        while (objectsPaises.hasNext()) {
            // Creo un objeto Paises y almaceno ahí el objeto que recupero de la BD
            Paises pais = (Paises) objectsPaises.next();
            // Imprimo las propiedades que me interesan de ese objeto
            System.out.println((j++) + " - " + "ID: " + pais.getId() + ", Pais: " + pais.getNombrePais());
        }
        agruparOperations(odb);
        ageMaxPlayers(odb);
        ageMinPlayers(odb);
        avgAgePlayers(odb);
        countPlayers(odb);
        sumAges(odb);
        queryCountryTennis(odb);
        queryAge14(odb);
        queryEUTennis(odb);
        query14SpaItaFra(odb);
        query15Italy(odb);
        odb.close(); //Cerrar BD
    }

    private static void agruparOperations(ODB odb) {
        Values values = odb.getValues(new ValuesCriteriaQuery(Jugadores.class, Where.isNotNull("pais.nombrePais"))
                        .field("pais.nombrePais").count("nombre").max("edad").sum("edad").groupBy("pais.nombrePais"));
        if (valores.size() == 0) {
            System.out.println("No hay ningún resultado");
        } else {

        }
//        Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class, Where.isNotNull("pais.nombrePais")).field("pais.nombrePais").count("nombre").max("edad").sum("edad").groupBy("pais.nombrePais"));
//        if (valores.size() == 0) {
//            System.out.println("No hay ningún resultado");
//        } else {
//            while (valores.hasNext()) {
//                ObjectValues ov = valores.next();
//                BigDecimal sumaEdades = (BigDecimal) ov.getByIndex(3);
//                BigInteger cuentaJugadores = (BigInteger) ov.getByIndex(1);
//                float media = sumaEdades.floatValue() / cuentaJugadores.floatValue();
//                System.out.println("El pais " + ov.getByIndex(0) + " tiene " + ov.getByIndex(1) + " jugadores y la media de edad es " + media + ", en total suman " + sumaEdades + " años, y el de mayor edad tiene " + ov.getByIndex(2));
//            }
//        }

    }

    private static void ageMaxPlayers(ODB odb) {
        Values values = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).max("edad"));
        ObjectValues ov = values.nextValues();
        System.out.println("======================================================");
        System.out.println("La edad máxima de los jugadores es: " + ov.getByAlias("edad"));
    }

    private static void ageMinPlayers(ODB odb) {
        Values values = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).min("edad"));
        ObjectValues ov = values.nextValues();
        System.out.println("======================================================");
        System.out.println("La edad mínima de los jugadores es: " + ov.getByAlias("edad"));
    }

    private static void avgAgePlayers(ODB odb) {
        Values values = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).avg("edad"));
        ObjectValues ov = values.nextValues();
        System.out.println("======================================================");
        System.out.println("La media de la edad de los jugadores es: " + ov.getByAlias("edad"));
    }

    private static void countPlayers(ODB odb) {
        Values values = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).count("nombre"));
        ObjectValues ov = values.nextValues();
        System.out.println("======================================================");
        System.out.println("El número de jugadores es: " + ov.getByAlias("nombre"));
    }

    private static void sumAges(ODB odb) {
//        // Suma de edades
//        Values val = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).sum("edad"));
//        ObjectValues ov= val.nextValues();
//        BigDecimal value = (BigDecimal)ov.getByAlias("edad");
//// también valdría BigDecimal value = (BigDecimal)ov.getByIndex(0);
        Values values = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).sum("edad"));
        ObjectValues ov = values.nextValues();
        System.out.println("======================================================");
        System.out.println("La suma de las edades es: " + ov.getByAlias("edad"));
    }


    private static void query15Italy(ODB odb) {
        Values values = odb.getValues(new ValuesCriteriaQuery(Jugadores.class, new
                And().add(Where.equal("pais.nombrePais", "Italia"))
                .add(Where.equal("edad", 15)))
                .field("nombre")
                .field("edad"));
        System.out.println("======================================================");
        System.out.println("Hay " + values.size() + " persona que tiene 15 años y vive en Italia:");
        for (ObjectValues j : values) {
            System.out.println(j.toString());
        }

    }

    private static void query14SpaItaFra(ODB odb) {
        Objects<Jugadores> objects = odb.getObjects(new CriteriaQuery
                (Jugadores.class, new And().add(Where.equal("edad", 14))
                        .add(new Or().add(Where.iequal("pais.nombrePais", "ESPAÑA"))
                                .add(Where.equal("pais.nombrePais", "Italia"))
                                .add(Where.equal("pais.nombrePais", "Francia")))));
        System.out.println("======================================================");
        System.out.println("Hay " + objects.size() + " persona que tiene 14 años y vive que practica tenis:");
        for (Jugadores j : objects) {
            System.out.println(j.toString());
        }
    }

    private static void queryEUTennis(ODB odb) {
//        ICriterion criterio = new And().add(Where.equal("pais.nombrePais", "EEUU"))
//                .add(Where.equal("deporte", "tenis"));
//        Objects<Jugadores> objects = odb.getObjects(new CriteriaQuery
//                (Jugadores.class, criterio));
        Objects<Jugadores> objects = odb.getObjects(new CriteriaQuery
                (Jugadores.class, new And().add(Where.equal("pais.nombrePais", "EEUU"))
                        .add(Where.equal("deporte", "tenis"))));
        System.out.println("======================================================");
        System.out.println("Hay " + objects.size() + " pais que practica tenis:");
        for (Jugadores j : objects) {
            System.out.println(j.toString());
        }
    }

    private static void queryCountryTennis(ODB odb) {
//      IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("deporte", "tenis"));
        Objects<Jugadores> objects = odb.getObjects(new CriteriaQuery
                (Jugadores.class, Where.equal("deporte", "tenis")).orderByAsc("nombre,edad"));
        System.out.println("======================================================");
        System.out.println("Hay " + objects.size() + " paises que practican tenis:");
        for (Jugadores j : objects) {
            System.out.println(j.getPais().getNombrePais());
        }
    }

    private static void queryAge14(ODB odb) {
        IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("edad", 14));
        query.orderByAsc("nombre,edad");
        Objects<Jugadores> objects = odb.getObjects(query);
        System.out.println("======================================================");
        System.out.println("Hay " + objects.size() + " personas que tienen 14 años:");
        for (Jugadores j : objects) {
            System.out.println(j.toString());
        }
    }

}