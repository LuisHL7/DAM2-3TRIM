/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testeandoconexionmongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Jeff
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        listarColeccionAmigos();
        listarColumnasBD();
    }

    public static void listarColeccionAmigos() {
        MongoCollection <Document> coleccion = Conexion.conexion();
        List<Document> consulta = coleccion.find().into(new ArrayList<>());
        for (int i = 0; i < consulta.size(); i++) {//mostramos los documentos
            System.out.println(" ----> " + consulta.get(i).toJson());
//            System.out.println(consulta.get(i).get("nombre"));
//            Document alumno = consulta.get(i); //recuperamos un documento No es necesario crear un documento para obtener valor por valor de la colección.
//            System.out.println(alumno.getString("nombre")+ "\n"+ alumno.getInteger("teléfono") + "\n"+  alumno.getString("curso"));
        }
    }
    
     public static void insertarColeccionAmigos() {
        MongoCollection <Document> coleccion = Conexion.conexion();
        Document amigo = new Document();
        amigo.put("nombre", "Luis");
        amigo.put("teléfono", 9876542);
        amigo.put("curso", "1 DAM");
        amigo.put("nota", 8);
        coleccion.insertOne(amigo);
    }
     
     public static void insertarColeccionAmigos2(){
        MongoCollection <Document> coleccion = Conexion.conexion();
        Document amigo = new Document("nombre", "Yole")
        .append("teléfono", 1234)
        .append("curso",
        new Document("curso1", "1DAM").append("curso2", "2DAM"));
        coleccion.insertOne(amigo);
        
    }
     
     public static void insertarVariosColeccionAmigos(){
        MongoCollection <Document> coleccion = Conexion.conexion();
        List <Document> listadocs = new ArrayList <>();
        for(int i =0; i< 5; i++) {
            listadocs.add(new Document("Valor de i", i));
        }
        coleccion.insertMany(listadocs);
        //Si se desea saber los documentos de la colección se puede utilizar el método count.
        //Numero de documentos de la coleccion.
        System.out.println("Nº Documentos: " +coleccion.countDocuments());
    }
     
     public static void listarColeccionConCursor(){
        MongoCollection <Document> coleccion = Conexion.conexion();
        try ( //Recuperar todos los documentos de la colección y visualizarlos en formato Json:
        //creamos el cursor
            MongoCursor <Document> cursor = coleccion.find().iterator()) {
            System.out.println("Usando Cursor");
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println(doc.toJson());
            }
            //cerramos el cursor
            cursor.close();
        }
        //Si solo queremos obtener el primer elemento utilizamos el método first()
        //obtenermos el primer documento
        System.out.println("Primer documento");
        System.out.println(coleccion.find().first().toJson());
     }
     
     public static void borrarElementoEnColeccion(){
         MongoCollection <Document> coleccion = Conexion.conexion();
//         coleccion.deleteOne(new Document("nombre", "Juanito"));
         //borrar todos lo alumnos de 1DAM menos los de array
//         coleccion.deleteMany(new Document("curso", "1DAM"));
//         //borrar toda la colección
         coleccion.deleteMany( new Document("_id", new Document("$exists", true)));
     }
     
     public static void listarColumnasBD(){
        MongoClient cliente = new MongoClient(); // nos conectamos a MongoDB
        MongoDatabase db = cliente.getDatabase("mibasedatos");
        MongoIterable <String> colecciones = db.listCollectionNames();
        Iterator col = colecciones.iterator();
        while(col.hasNext()) {
            System.out.println(col.next());
        }
     }
     

}
