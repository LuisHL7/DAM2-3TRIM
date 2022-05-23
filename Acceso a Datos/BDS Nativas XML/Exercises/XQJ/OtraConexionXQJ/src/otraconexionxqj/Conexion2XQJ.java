package otraconexionxqj;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import net.xqj.exist.ExistXQDataSource;

/**
 *
 * @author Jeff
 */
public class Conexion2XQJ {

    public static XQConnection conectar() {
        XQConnection conexion = null;
        try {
            XQDataSource recurso = new ExistXQDataSource();
            recurso.setProperty("serverName", "localhost");//configuramos servidor
            recurso.setProperty("port", "8080");       //configuramos el puerto
            conexion = recurso.getConnection("admin", "");//creamos conexión.
        } catch (XQException e) {
            System.out.println("No se pudo conectar correctamente.");
        }
        return conexion;
    }
}
