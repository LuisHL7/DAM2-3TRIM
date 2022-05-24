package exercisexmldb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
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
            File fichero = new File("zonas.xml");
            Resource resource = colecciones.createResource(fichero.getName(),"XMLResource"); // Instanciamos la clase para crear un recurso
            resource.setContent(fichero); // 
            colecciones.storeResource(resource); // subimos un fichero
            System.out.println("La colección nuevaColeccion fue creada y el fichero zonas.xml añadido correctamente  ");
            
        } catch (XMLDBException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error=> " + ex.getMessage());
        }
    }
    
    public static void borrarColeccion() throws Exception {
        try {
            Collection colecciones = Conexion.conectar();
            CollectionManagementService mgtService = (CollectionManagementService) colecciones.getService("CollectionManagementService", "1.0");
            mgtService.removeCollection("nuevaColeccion"); // Eliminamos la colección
            System.out.println("Colección nuevaColeccion eliminada correctamente");
        } catch (XMLDBException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error=> " + ex.getMessage());
        }
    }
    
    public static void borrarFichero () throws Exception {
        String nombreFichero = "socios_gim.xml";
        try {
            Collection colecciones = Conexion.conectar();
            boolean comprobar = false;
            Collection col = colecciones.getChildCollection("ColeccionGimnasio"); // Obtenemos la colección hija con este nombre
             
            if (col != null) { // Comprobamos que exista la colección
                String [] documentos = col.listResources(); // Obtenemos la lista de los ficheros de la colección.
                for (int i = 0; i < documentos.length && !comprobar; i++) {
                    if (documentos[i].equalsIgnoreCase(nombreFichero)) { // Comprobamos que exista el fichero dentro de la colección
                        Resource recursoParaBorrar = col.getResource(nombreFichero); // Obtenemos el fichero
                        col.removeResource(recursoParaBorrar);   // Eliminamos el fichero
                        comprobar = true;
                    }
                }
               
                if (comprobar) {
                    System.out.println("Fichero " + nombreFichero + " eliminado correctamente");
                } else {
                    System.err.println("No existe el fichero " + nombreFichero);
                }
                
            } else {
                System.err.println("La colección ingresada no existe.");
            }
        } catch (XMLDBException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error=> " + ex.getMessage());
        }
    }
    
    public static void modificarProductos () throws Exception { 
        
        System.out.println("******MODIFICAR UN PRODUCTO*******");
        System.out.println("******XQuery*******\n");
        consulta("for $producto in /productos/produc/stock_actual" +
                " return update value $producto with $producto + 10" , true);
        System.out.println("--> Registro modificado correctamente");
    
    }
    
    public static void bajarDocumento () throws Exception {
        String nombreFichero = "universidad.xml";
        try { 
            Collection colecciones = Conexion.conectar();
            XMLResource recurso = (XMLResource) colecciones.getResource(nombreFichero); // Instanciamos un recurso XML
            
            if (recurso != null) {
                // Volcado del documento a un arbol DOM
                Node document = (Node) recurso.getContentAsDOM();
                Source source = new DOMSource(document);

//               Muestra los datos recogidos en consola.
//               Transformer transformer = TransformerFactory.newInstance().newTransformer();
//               Result console = new StreamResult(System.out);
//               transformer.transform(source, console);

                // Volcado del documento a un fichero
                Result fichero = new StreamResult(new java.io.File("./collage.xml"));  // Creamos un fichero con este nombre en la raíz del proyecto
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, fichero);
                System.out.println("Fichero leido y guardado en otro fichero correctamente");
            } else {
                System.err.println("No existe este fichero");
            }

        } catch (XMLDBException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error=> " + ex.getMessage());
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ejecutarConsultaFichero () throws Exception{ 
        String nombreFichero = "miconsulta.xq" ;
        File fichero = new File(nombreFichero);  
        String consultaFichero;
        
        try {
            if (!fichero.exists()) { // Creamos el fichero si no existe
                fichero.createNewFile(); 
                try (DataOutputStream wr = new DataOutputStream(new FileOutputStream(fichero, true))) {
                    wr.writeUTF("for $productos in /productos/produc[precio > 50 and cod_zona = 10] return $productos"); // Escribimos la consulta
                }
            }       
            try (DataInputStream r = new DataInputStream(new FileInputStream(fichero))) {
                consultaFichero = r.readUTF(); // Leemos los datos del fichero
            } 
            System.out.println("******Listado de todos los productos con precio > 50 y zona 10*******");
            consulta(consultaFichero, false);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
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
