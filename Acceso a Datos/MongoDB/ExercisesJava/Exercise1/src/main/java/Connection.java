import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    public static void main(String[] args) {
        MongoClient cliente = new MongoClient(); // nos conectamos a MongoDB
        MongoDatabase db = cliente.getDatabase("mibasedatos"); // nos conectamos a la base de datos
        MongoCollection<Document> coleccion = db.getCollection("amigos"); //obtenemos la coleccion

        // MongoCollection es una interfaz genérica:
//y es el tipo predeterminado para devolver la búsqueda (.find) y agregados (.aggregate).
//El método de un solo argumento getCollection devuelve una instancia de MongoCollection <Document>
//el método .find().into()
        List<Document> consulta = coleccion.find().into(new ArrayList<Document>());
//recorremos la lista
        for (int i = 0; i < consulta.size(); i++) {//mostramos los documentos
            System.out.println(" ---- " + consulta.get(i).toString());
            Document alumno = consulta.get(i); //recuperamos un documento
            System.out.println(alumno.getString("nombre") + "\t" + //recuperar los valores de los campos del documento, utilizando los métodos get del objeto Document
                    alumno.get("telefono") + "\t" + alumno.getString("curso"));
        }
    }
}
