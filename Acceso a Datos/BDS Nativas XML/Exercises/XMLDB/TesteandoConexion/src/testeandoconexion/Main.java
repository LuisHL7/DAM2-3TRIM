package testeandoconexion;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;

/**
 * Realizo la consulta despúes de conectarme satisfactoriamente
 * @author Luis
 */
public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException {
        Collection col = ConexionXMLDB.conectar();
        if (col != null) {
            try {
//              String consultaXPath = "/bib/libro/titulo"; FUNCIONA
//              String consultaXQuery = "for $book in collection('/db/ColeccionesXML/ColeccionPruebas')/bib/libro order by $book/@año return <libro> {$book/@año} {$book/titulo }</libro>"; FUNCIONA              
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //ResourceSet result = servicio.query("for $dep in /departamentos/DEP_ROW return $dep");
                ResourceSet result = servicio.query("for $libro in collection('/db/ColeccionesXML/ColeccionPruebas')/bib/libro return $libro/titulo");
                ResourceIterator i = result.getIterator();  // recorrer los datos del recurso. 
                if (!i.hasMoreResources()) { // comprueba si hay valores
                    System.out.println("La consulta no devuelve nada o está mal escrita");
                } else {
                    System.out.println("******Listado de Libros*******");
                    System.out.println("******XQuery*******\n");
                    while (i.hasMoreResources()) {
                        Resource r = i.nextResource();
                        System.out.println("--------------------------------------------");
                        System.out.println((String) r.getContent());
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

}
