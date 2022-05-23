package exercisexmldb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XPathQueryService;

public class Operaciones {

    private static void consulta(String consulta, boolean tipo) throws Exception {
        Collection col = Conexion.conectar();
        if (col != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                ResourceSet result = servicio.query(consulta);
                ResourceIterator i = result.getIterator();  // recorrer los datos del recurso. 
                if (!i.hasMoreResources() && !tipo) { // comprueba si hay valores
                    System.out.println("--> La consulta no devuelve nada o está mal escrita");
                } else {
                    while (i.hasMoreResources()) {
                        Resource r = i.nextResource();
                        System.out.println((String) r.getContent());
                        System.out.println("--------------------------------------------");
                    }
                }
                col.close();
            } catch (XMLDBException e) {
                System.out.println(" Error al consultar el documento.");
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }
    }

    public static void empleadosDepartamento10() throws Exception {
        System.out.println("******Listado de Empleados que pertenecen al departamento 10*******");
        System.out.println("******XQuery*******\n");
        consulta("for $empleados in /EMPLEADOS/EMP_ROW where $empleados/DEPT_NO=10  return $empleados", false);
    }

    public static void verColecciones() throws Exception {

        try {
            Collection colecciones = Conexion.conectar();
            String[] lista = colecciones.listChildCollections();
            for (String col : lista) {
                System.out.println("Nombre de la colección: " + col);
            }
        } catch (XMLDBException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error=> " + ex.getMessage());
        }
    }

    public static void verRecursosdeColecciones() throws Exception {

        try {
            Collection colecciones = Conexion.conectar();
            String[] lista = colecciones.listChildCollections();
            for (var col : lista) {
                System.out.println("-->" + col);
                Collection colRecursos = colecciones.getChildCollection(col); // Obtenemos la colección hija
                String[] recursos = colRecursos.listResources(); // Obtenemos los ficheros de cada colección.
                for (String recurso : recursos) {
                    System.out.println("-------->" + recurso);
                }
            }
        } catch (XMLDBException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error=> " + ex.getMessage());
        }
    }

    public static void crearColeccionYSubirFichero() throws Exception {
        try {
            //CREAR COLECCIÓN
            Collection colecciones = Conexion.conectar();
            CollectionManagementService mgtService = (CollectionManagementService) colecciones.getService("CollectionManagementService", "1.0"); // Instanciamos el servicio para manejar las colecciones.
            mgtService.createCollection("nuevaColeccion"); // Creamos una colección
            //SUBIR FICHERO
            
        } catch (XMLDBException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error=> " + ex.getMessage());
        }
    }

    public static void listarTodosLosDepartamentos() throws Exception {
        System.out.println("******Listado de todos los departamentos*******");
        System.out.println("******XQuery*******\n");
        consulta("for $departamento in doc(\"departamentos.xml\")/departamentos/DEP_ROW return $departamento", false);
    }

    public static void insertarDepartamento() throws Exception {
        System.out.println("******INSERTANDO UN DEPARTAMENTO*******");
        System.out.println("******XQuery*******\n");
        consulta("update insert <DEP_ROW> "
                + "<DEPT_NO>21</DEPT_NO>"
                + "<DNOMBRE> El 21</DNOMBRE>"
                + "<LOC>Vigo</LOC>"
                + "</DEP_ROW>"
                + "into doc(\"departamentos.xml\")/departamentos", true);
        System.out.println("--> Registro insertado correctamente");
    }

    public static void consultarDepartamento() throws Exception {
        System.out.println("******CONSULTAR UN DEPARTAMENTO*******");
        System.out.print("Ingrese el número de departamento: ");
        int numero = VerificarDatos.leerNumero();
        System.out.println("******XQuery*******\n");
        consulta("for $departamento in doc(\"departamentos.xml\") /departamentos/DEP_ROW where $departamento/DEPT_NO=" + numero + "return $departamento", false);
    }

    public static void modificarDepartamento() throws Exception {
        System.out.println("******MODIFICAR UN DEPARTAMENTO*******");
        System.out.print("Ingrese el número de departamento: ");
        int numero = VerificarDatos.leerNumero();
        System.out.print("Ingrese un nuevo nombre par el departamento: ");
        String nombre = VerificarDatos.leerString();
        System.out.println("******XQuery*******\n");
        consulta("update value doc(\"departamentos.xml\")"
                + "/departamentos/DEP_ROW[DEPT_NO=" + numero
                + "]/DNOMBRE with'" + nombre + "'", true);
        System.out.println("--> Registro modificado correctamente");
    }

    public static void eliminarDepartamento() throws Exception {
        System.out.println("******ELIMINAR UN DEPARTAMENTO*******");
        System.out.print("Ingrese el número de departamento: ");
        int numero = VerificarDatos.leerNumero();
        System.out.println("******XQuery*******\n");
        consulta("update delete doc(\"departamentos.xml\")"
                + "/departamentos/DEP_ROW[DEPT_NO=" + numero
                + "]", true);
        System.out.println("--> Registro eliminado correctamente");
    }
}
