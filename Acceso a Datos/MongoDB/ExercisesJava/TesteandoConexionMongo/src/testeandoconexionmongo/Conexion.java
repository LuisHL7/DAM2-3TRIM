package testeandoconexionmongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeff
 */
public class Conexion {

    public static MongoCollection <Document>  conexion() {
        MongoClient cliente = new MongoClient(); // nos conectamos a MongoDB
        MongoDatabase db = cliente.getDatabase("mibasedatos"); // nos conectamos a la base de datos
        MongoCollection<Document> coleccion = db.getCollection("amigos"); //obtenemos la coleccion
        return db.getCollection("amigos"); 
    }
}
