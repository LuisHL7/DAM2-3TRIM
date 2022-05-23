package otraconexionxqj;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQMetaData;
import javax.xml.xquery.XQResultSequence;

/**
 *
 * @author Jeff
 */
public class MainXQJ2 {

    public static void main(String[] args) {
        XQConnection connection = null;
        try {
            connection = Conexion2XQJ.conectar();
            XQMetaData xqmd = connection.getMetaData();
            System.out.println("Conexión establecida como: " + xqmd.getUserName());
            System.out.println(
                    "Producto: " + xqmd.getProductName() + ", " + "versión: " + xqmd.getXQJMajorVersion() + "." + xqmd.getXQJMinorVersion() + ".\n"
                    + "Soporte para transacciones: " + (xqmd.isTransactionSupported() ? "Sí" : "No") + ".\n"
                    + "Validación con esquemas: " + (xqmd.isSchemaValidationFeatureSupported() ? "Sí" : "No") + ".\n"
                    + "Serialización: " + (xqmd.isSerializationFeatureSupported() ? "Sí" : "No") + ".\n"
            );
            
            String consultaXQuery = "for $libro in collection('/db/ColeccionesXML/ColeccionPruebas')/bib/libro return $libro/titulo";
            XQExpression query = connection.createExpression();
            XQResultSequence result1 = query.executeQuery(consultaXQuery);
            
            System.out.println("******LIBROS*******");
            
            System.out.println("******XQuery*******\n");
            while (result1.next()) {
                System.out.println(result1.getItemAsString(null));
            }
        } catch (XQException e) {
            muestraErrorXQuery(e);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (XQException xe) {
                xe.getMessage();
            }
        }
    }

    private static void muestraErrorXQuery(XQException e) {
        System.err.println("XQuery ERROR mensaje: " + e.getMessage());
        System.err.println("XQuery ERROR causa: " + e.getCause());
        System.err.println("XQuery ERROR código: " + e.getVendorCode());
    }
}

