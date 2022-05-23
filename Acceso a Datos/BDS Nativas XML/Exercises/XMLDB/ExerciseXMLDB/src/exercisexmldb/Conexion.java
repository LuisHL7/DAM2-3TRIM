/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercisexmldb;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.xmldb.api.*;
import org.xmldb.api.base.*;

/**
 *
 * @author Jeff
 */
public class Conexion {
    public static Collection conectar() throws NoSuchMethodException, InstantiationException {

        try {
            Class cl = Class.forName("org.exist.xmldb.DatabaseImpl"); //Cargar del driver 
            Database database;
            try {
                database = (Database) cl.getDeclaredConstructor().newInstance();//Instanciando bd
                DatabaseManager.registerDatabase(database); //Registro del driver
                Collection col = DatabaseManager.getCollection(
                        "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionEmpleados",
                        "admin", ""); //uri-user-pass
                return col;
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (XMLDBException e) {
            System.out.println("Error al inicializar la BD eXist.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el driver.");
        } catch (InstantiationException e) {
            System.out.println("Error al instanciar la BD.");
        }
        return null;
    }
    
}
