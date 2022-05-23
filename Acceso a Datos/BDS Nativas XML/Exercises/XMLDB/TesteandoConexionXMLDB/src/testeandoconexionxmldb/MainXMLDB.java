package testeandoconexionxmldb;

import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

/**
 *
 * @author Jeff
 */
public class MainXMLDB {
    public static void main(String[] args) throws Exception {
           Collection col = ConexionXMLDB.conectar();
        if (col != null) {
            try {
//              String consultaXPath = "/bib/libro/titulo"; FUNCIONA
//              String consultaXQuery = "for $book in collection('/db/ColeccionesXML/ColeccionPruebas')/bib/libro order by $book/@año return <libro> {$book/@año} {$book/titulo }</libro>"; FUNCIONA              
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //ResourceSet result = servicio.query("for $dep in /departamentos/DEP_ROW return $dep");
                ResourceSet result = servicio.query("for $book in collection('/db/ColeccionesXML/ColeccionPruebas')/bib/libro/titulo return $book");

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
