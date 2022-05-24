/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercisexqj;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

/**
 *
 * @author Jeff
 */
public class Operaciones {

    public static void consulta(String consulta) {
        XQConnection connection = null;
        try {
            connection = Conexion.conectar();
            XQExpression query = connection.createExpression();
            XQResultSequence result1 = query.executeQuery(consulta);
            while (result1.next()) {
                System.out.println(result1.getItemAsString(null));
            }
        } catch (XQException e) {
            System.err.println("XQuery ERROR mensaje: " + e.getMessage());
            System.err.println("XQuery ERROR causa: " + e.getCause());
            System.err.println("XQuery ERROR código: " + e.getVendorCode());
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
    
    public static void listarProductos() {
        System.out.println("******Listado de todos los productos*******");
        System.out.println("******XQuery*******\n");
        consulta("for $producto in collection('/db/ColeccionEmpleados')" +
                "/productos/produc return $producto");
    }
    
     public static void productosConPrecioMayorA50() {
        System.out.println("******Cantidad de Productos que tienen un precio mayor a 50*******");
        System.out.println("******XQuery*******\n");
        consulta("count(for $producto in collection('/db/ColeccionEmpleados')" +
                "/productos/produc where precio > 50 return $producto)");
    }
     
      public static void cantidadDeProductosPorZona() {
        System.out.println("******Cantidad de Productos por zona*******");
        System.out.println("******XQuery*******\n");
        consulta("for $zona in distinct-values(collection('/db/ColeccionEmpleados')" +
               "/productos/produc/cod_zona/data())"+
                "let $productosZona := count(collection('/db/ColeccionEmpleados')" +
                "/productos/produc[cod_zona = $zona])" +
                "return $productosZona ");
     }
      
     public static void productoMayoresDe50yZona10() {
        System.out.println("******Productos con precio mayores de 50 y de la zona 10*******");
        System.out.println("******XQuery*******\n");
        String nombreFichero = "miconsulta.xq" ;
        File fichero = new File(nombreFichero);  
        String consultaFichero;
        try {
            if (!fichero.exists()) { // Creamos el fichero si no existe
                fichero.createNewFile(); 
                try (DataOutputStream wr = new DataOutputStream(new FileOutputStream(fichero, true))) {
                    wr.writeUTF("for $producto in collection('/db/ColeccionEmpleados')" +
                "/productos/produc where precio>50 and cod_zona = 10 return $producto"); // Escribimos la consulta
                }
            }       
            try (DataInputStream r = new DataInputStream(new FileInputStream(fichero))) {
                consultaFichero = r.readUTF(); // Leemos los datos del fichero
            } 
            System.out.println("******Listado de todos los productos con precio > 50 y zona 10*******");
            consulta(consultaFichero);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public static void guardarConsultaEnFichero() {
          BufferedWriter bw = null;
          XQConnection connection;
          String consulta = "for $empleados in /EMPLEADOS/EMP_ROW where $empleados/DEPT_NO=10  return $empleados";
        try {
            connection = Conexion.conectar();
            XQResultSequence resultQ = connection.createExpression().executeQuery(consulta);
            bw = new BufferedWriter(new FileWriter("NUEVO_EMPLE10.xml"));
            bw.write("""
                     <?xml version='1.0' encoding='ISO-8859-1'?>
                     """);
            while(resultQ.next()) {
                String resultado = resultQ.getItem().getItemAsString(null);
                System.out.println("Consola " + resultado); // visualizamos
                bw.write(resultado + "\n"); // grabamos en el fichero
            }
            bw.close(); // Cerramos el fichero el fichero

        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (XQException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(bw!= null) {
                    bw.close();
                }         
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
     }
     
     public static void mostrarProductos() {
        System.out.println("******Cantidad de Productos por zona*******");
        System.out.println("******XQuery*******\n");
//        consulta("//productos");
        consulta("for $producto in collection('/db/ColeccionEmpleados')" +
                "/productos return $producto");
     }
}
