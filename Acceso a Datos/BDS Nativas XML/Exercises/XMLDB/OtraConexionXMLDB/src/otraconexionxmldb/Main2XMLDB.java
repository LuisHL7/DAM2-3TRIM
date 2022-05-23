
package otraconexionxmldb;
import org.xmldb.api.base.*;

/**
 *
 * @author Jeff
 */
public class Main2XMLDB {

    public static void main(String[] args) {
        Collection col = null;
        try {
            col = Conexion2XMLDB.conectar("/ColeccionesXML/ColeccionPruebas");
            System.out.println("Colección actual: " + col.getName());

            int numHijas = col.getChildCollectionCount();
            System.out.println(numHijas + " colecciones hijas.");
            if (numHijas > 0) {
                String nomHijas[] = col.listChildCollections();
                for (int i = 0; i < numHijas; i++) {
                    System.out.println("\t" + nomHijas[i]);
                }
            }
            int numDocs = col.getResourceCount();
            System.out.println(numDocs + " doocumentos.");
            if (numDocs > 0) {
                String nomDocs[] = col.listResources();
                for (int i = 0; i < numDocs; i++) {
                    System.out.println("\t" + nomDocs[i]);
                }
            }

            Service servicios[] = col.getServices();
            System.out.println("Servicios proporcionados por colección " + col.getName() + ":");
            for (int i = 0; i < servicios.length; i++) {
                System.out.println("\t" + servicios[i].getName() + " - Versión: " + servicios[i].getVersion());
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (col != null) {
                    col.close();
                }
            } catch (XMLDBException e) {
                 e.getMessage();
            }
        }
    
    }
    
}
