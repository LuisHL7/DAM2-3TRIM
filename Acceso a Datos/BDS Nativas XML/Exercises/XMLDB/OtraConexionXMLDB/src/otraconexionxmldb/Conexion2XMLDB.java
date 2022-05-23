package otraconexionxmldb;
import org.xmldb.api.*;
import org.xmldb.api.base.*;

/**
 * Realiza la conexción con la ubicación donde estan los xml que van a ser
 * léídos
 *
 * @author Luis
 */
public class Conexion2XMLDB {

    public static Collection conectar(String nomCol) throws Exception {
        Database dbDriver;
        Collection col;
        dbDriver = (Database) Class.forName("org.exist.xmldb.DatabaseImpl").newInstance();
        DatabaseManager.registerDatabase(dbDriver);
        col = DatabaseManager.getCollection(
                "xmldb:exist://localhost:8080/exist/xmlrpc/db" + nomCol,
                "admin", "");
        return col;
    }
    
}
