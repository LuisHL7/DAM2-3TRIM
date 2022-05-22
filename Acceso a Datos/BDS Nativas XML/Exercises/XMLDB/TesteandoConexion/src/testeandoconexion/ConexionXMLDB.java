package testeandoconexion;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.xmldb.api.*;
import org.xmldb.api.base.*;

/**
 * Realiza la conexción con la ubicación donde estan los xml que van a ser
 * léídos
 *
 * @author Luis
 */
public class ConexionXMLDB {

    public static Collection conectar() throws NoSuchMethodException, InstantiationException {

        try {
            Class cl = Class.forName("org.exist.xmldb.DatabaseImpl"); //Cargar del driver 
            Database database;
            try {
                database = (Database) cl.getDeclaredConstructor().newInstance();//Instanciando bd
                DatabaseManager.registerDatabase(database); //Registro del driver
                Collection col = DatabaseManager.getCollection(
                        "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionesXML/ColeccionPruebas",
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
