package Exits_XMLDB.Query;

import net.xqj.exist.ExistXQDataSource;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

public class Exists {

    /*Crea un proyecto JAVA que después de conectarse a la base de datos eXist:

    visualice una relación de todos los libros que hay en el fichero libros.xml
    contabilice cuántos hay.
    */
    private XQConnection createConnection() {

        XQConnection conexion = null;
        try {
            XQDataSource recurso = new ExistXQDataSource();
            recurso.setProperty("serverName", "localhost");
            recurso.setProperty("port", "8080");

            //Configurados puerto y servidor , creamos conexi�n.
            conexion = recurso.getConnection("admin", "");
        } catch (XQException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public static void main(String[] args) {

        Exists exist = new Exists();
        XQConnection connection = exist.createConnection();

        if (connection == null) {
            throw new IllegalArgumentException("Fallo al conectar con eXist. Los datos de conexión no son válidos");
        }

        String consultaXQuery = "for $libro in collection('/db/apps/collection')/bib/libro return $libro/titulo";
        String consultaXQuery2 = "for $libro in doc('file://Z://2021_2022//AADD7//UD_eXistDB//biblioteca.xml')/bib/libro return $libro/titulo";
        String consultaXPath = "/bib/libro/titulo";

        String expresion = " count(collection('/db/apps/collection')/bib/libro )";
        //String expresion = "count(/bib/libro )";

        try {
            XQExpression query = connection.createExpression();
            XQResultSequence result1 = query.executeQuery(consultaXQuery);

            XQPreparedExpression consulta2 = connection.prepareExpression(consultaXPath);
            XQResultSequence result2 = consulta2.executeQuery();

            XQPreparedExpression consulta3 = connection.prepareExpression(expresion);
            XQResultSequence result3 = consulta3.executeQuery();

            System.out.println("******LIBROS*******");

            System.out.println("******XQuery*******\n");
            while (result1.next()) {
                System.out.println(result1.getItemAsString());
            }

            System.out.println("******XPath*******\n");
            while (result2.next()) {
                System.out.println(result2.getItemAsString());
            }

            while (result3.next()) {
                System.out.println("******NumLibros*******");
                System.out.println(result3.getItemAsString());
            }

        } catch (XQException e) {
            e.printStackTrace();
        }
    }

}