import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Connection {
    public static void main(String[] args) {
        try {
            MongoClient cliente = new MongoClient(); // nos conectamos a MongoDB
            //MongoClient cliente = new MongoClient("localhost", 27017); También se puede escribir el nombre del servidor y el puerto
            MongoDatabase db = cliente.getDatabase("centroeducativo");   // nos conectamos a la base de datos
            MongoCollection<Document> collection =db.getCollection("alumnos");      //obtenemos la colección
            List<Document> consulta = collection.find().into(new ArrayList<>()); //Los datos de una colección se pueden cargar en una lista utilizando el método .find().into()

            //recorremos la lista
            for(int i = 0; i < consulta.size(); i++) {
                System.out.println(" ---- "+consulta.get(i).toString());
            }

            //Insertamos un registro.
//            insertarOne(collection);
            borrarDoc_D(collection);

            //


            consulta = collection.find().into(new ArrayList <>());
            //recorremos la lista de documentos (columna a columna o mejor dicho seleccionando determinados campos.)
            for(int i = 0; i < consulta.size(); i++) {
                //recuperamos un documento
                Document alumno = consulta.get(i);
                System.out.println(alumno.getString("nombre")+"\t"+
                        alumno.get("telefono")+"\t"+
                        alumno.get("curso"));
            }

        }catch (Exception ex) {
            System.out.println("Exception al conectar al server de Mongo: " + ex.getMessage());
        }
        finally{}
    }

    public static void insertarOne(MongoCollection <Document> collection){
        //Creamos el documento
        Document alumno = new Document();
        //le añadimos los campos
        alumno.put("nombre", "Jorge");
        alumno.put("telefono", 121212);
        alumno.put("curso", "2º Finz");
        alumno.put("fecha", new Date());
        //insertamos el documento en la collection
        collection.insertOne(alumno);
    }

    public static void insertarOne2(MongoCollection <Document> collection){
        // insertar otro documento en amigos
        Document alumno2 = new Document("nombre", "Marisa")
                .append("teléfono", 1234)
                .append("curso",
                        new Document("curso1", "1DAM").append("curso2", "2DAM"));
        collection.insertOne(alumno2);

    }

    public static void insertarMany(MongoCollection <Document> collection){
        List <Document> listadocs = new ArrayList <Document>();
        for(int i =0; i< 5; i++) {
            listadocs.add(new Document("Valor de i", i));
        }
        collection.insertMany(listadocs);
        //Si se desea saber los documentos de la colección se puede utilizar el método count.
        //Numero de documentos de la collection.
        System.out.println("Nº Documentos: " +collection.countDocuments());
    }

//    public static void consultarDocumentos_R(MongoCollection <Document> collection){
//        //Recuperar todos los documentos de la colección y visualizarlos en formato Json:
//        //creamos el cursor
//        MongoCursor <Document> cursor = collection.find().iterator();
//        System.out.println("Usando Cursor");
//        while(cursor.hasNext()) {
//            Document doc = cursor.next();
//            System.out.println(doc.toJson());
//        }
//        //cerramos el cursor
//        cursor.close();
//        //Si solo queremos obtener el primer elemento utilizamos el método first()
//        //obtenermos el primer documento
//        Document doc = collection.find().first();
//        System.out.println("Primer documento");
//        System.out.println(doc.toJson());
//    }
//
    public static void borrarDoc_D(MongoCollection <Document> collection){

        //un documento de la colección - deleteOne,
        //borrar varios                - deleteMany. También se devuelve un DeleteResult

        //Borrar el documento de nombre Patricia.
        //creamos el documento para la busqueda de todos los documentos
        Document findDocument = new Document("nombre", "Jorge");
        collection.deleteMany(findDocument);
//
//        //Borrar todos los alumnos de 2º DAM
//        //creamos el documento para la busqueda de todos los documentos
//        Document findDocument2 = new Document("curso", "2º DAM");
//        DeleteResult deleteResult1 = collection.deleteMany(findDocument2);
//
//        //Borramos todos los documentos.
//        //creamos el documento para la busqueda de todos los documentos
//        Document findDocument3 = new Document("_id", new Document("$exists", true));
//        DeleteResult deleteResult2 = collection.deleteMany(findDocument3);
    }
//
//    public static void actualizarDoc_U(MongoDatabase db,MongoCollection <Document> collection){
//
//        //Actualizar la nota de Ana asignándole un 6.
////        Para actualizar un único documento se utiliza el método updateOne,
//        //si hay varios con nombre Ana, actualiza el primero. La actualización devuelve un UpdateResult.
//
//        //creamos el documento para la busqueda de Ana
//        Document findDocument1 = new Document("nombre", "Ana");
//        //creamos el documento para la actualizacion
//        Document updateDocument1 = new Document("$set", new Document("nota", 6));
//        //ejecutamos la actualizacion
//        collection.updateOne(findDocument1, updateDocument1);
//
//        //Subir la nota a todos los alumnos de 2º DAM en 1 punto.
//        //En este caso se utiliza el método updateMany().
//
//        //creamos el documento para la busqueda de 2º DAM
//        Document findDocument2 = new Document("curso", "2º DAM");
//        //creamos el documento para la actualizacion
//        Document updateDocument2 = new Document("$inc", new Document("nota", 1));
//        //ejecutamos la actualizacion
//        UpdateResult updateResult2 = collection.updateMany(findDocument2, updateDocument2);
//        System.out.println("Se han actualizado " +updateResult2.getModifiedCount());
//        System.out.println("Se han seleccionado " +updateResult2.getMatchedCount()) ;
//
////        Actualizar todos los registros de la colección aumentándoles 2 puntos la nota.
////        Para actualizar todos los registros de la colección, se utiliza exists(“_id”) para que devuelva
////        todos los documentos que tienen _id:
////        La consulta en MongoDB sería: db.alumnos.find({_id: {$exists: true}})
//
////creamos el documento para la busqueda de todos los documentos
//        Document findDocument3 = new Document("_id", new Document("$exists", true));
//        //creamos el documento para la actualizacion
//        Document updateDocument3 = new Document("$inc", new Document("nota", 2));
//        //ejecutamos la actualizacion
//        UpdateResult updateResult3 = collection.updateMany(findDocument3,updateDocument3);
//
////        Para añadir un campo se utiliza el método set, si el campo no existe se crea.
////        Añadir la población Madrid a Isabel.
//
//        //creamos el documento para la busqueda de todos los documentos
//        Document findDocument4 = new Document("nombre", "Isabel");
//        //creamos el documento para la actualizacion
//        Document updateDocument4 = new Document("$set", new Document("poblacion", "Madrid"));
//        //ejecutamos la actualizacion
//        UpdateResult updateResult4 = collection.updateMany(findDocument4,updateDocument4);
//
//        //Eliminar el campo población a los alumnos de 1º DAM que lo tengan. Utilizamos es método unset.
//
//        //creamos el documento para la busqueda de todos los documentos
//        Document findDocument5 = new Document("curso", "1º DAM");
//        //creamos el documento para la actualizacion
//        Document updateDocument5 = new Document("$unset", new Document("poblacion","Madrid"));
//        //ejecutamos la actualizacion
//        UpdateResult updateResult5 = collection.updateMany(findDocument5, updateDocument5);
//    }
//
//    public static void filtrosConsultas(MongoCollection <Document> collection){
//        System.out.println("Filtros Consultas");
//        //Buscar el document con la clave nombre iagual a Ana, devolver el primero. Para ello
//        //añadimos el método first()
//        Document doc = collection.find(Filters.eq("nombre","Carmen")).first();
//        try {
//            System.out.println("Encontrado: " +doc.toJson());
//        }catch(NullPointerException np) {
//            System.out.println("No existe");
//        }
//
////        Si el filtro devuelve varios documentos los recuperamos con el cursor, o bien con una lista.
////        Recuperar los alumnos con nota superior a 5, visualizarlos en Json.
//        //creamos el cursor
//        MongoCursor <Document> cursor1 = collection.find(Filters.gt("nota", 5)).iterator();
//        //recorremos el cursor
//        while(cursor1.hasNext()) {
//            Document alumno = cursor1.next();
//            System.out.println(alumno.toJson());
//        }
//        cursor1.close();
//
//        //Obtener los alumnos con nota = 5 o nota = 8
//        //creamos el cursor
//        MongoCursor <Document> cursor2 = collection.find(Filters.or(Filters.eq("nota", 5), Filters.eq("nota", 8))).iterator();
//        //recorremos el cursor
//        while(cursor2.hasNext()) {
//            Document alumno = cursor2.next();
//            System.out.println(alumno.toJson());
//        }
//        cursor2.close();
//
//        //Obtener los alumnos de 1º DAM y nota 8
//        //creamos el cursor
//        MongoCursor <Document> cursor3 = collection.find(Filters.and(Filters.eq("nota", 8),Filters.eq("curso", "1º DAM"))).iterator();
//        //recorremos el cursor
//        while(cursor3.hasNext()) {
//            Document alumno = cursor3.next();
//            System.out.println(alumno.toJson());
//        }
//        cursor3.close();
//    }
//
//    public static void usoProyecciones(MongoCollection <Document> collection){
//        System.out.println("Uso Proyecciones");
//        //Obtener el nombre y la nota de los alumnos de 1º DAM ordenados por nombre
//        MongoCursor <Document> cursor1 = collection.find(eq("curso", "1ºDAM"))
//                .sort(ascending("nombre"))
//                .projection(include("nombre", "nota")).iterator();
//        //recorremos el cursor
//        while(cursor1.hasNext()) {
//            Document alumno = cursor1.next();
//            System.out.println(alumno.toJson());
//        }
//        cursor1.close();
//
////        Si no se desea incluir en la consulta algunos de los campos se puede utilizar el método exclude.
////        Para la alumna Ana no mostrar el _id, el nombre y la nota
//        //obtenemos el documento
//        Document alumno = collection.find(eq("nombre", "Ana"))
//                .projection(exclude("_id", "nombre","nota")).first();
//        System.out.println(alumno.toJson());
//
//        //Obtener el nombre y la nota de los 3 primeros alumnos de 1º DAM ordenados por nombre
//        MongoCursor <Document> cursor2 = collection.find(eq("curso", "1ºDAM"))
//                .sort(ascending("nombre"))
//                .projection(include("nombre", "nota")).limit(3).iterator();
//        //recorremos el cursor
//        while(cursor2.hasNext()) {
//            Document alumno2 = cursor2.next();
//            System.out.println(alumno2.toJson());
//        }
//        cursor2.close();
//    }
//
//    public static void usoAgregaciones(MongoCollection <Document> collection){
//        System.out.println("Uso Agregaciones");
//        //Obtener el nombre y la nota de los alumnos de 1º DAM, utilizando las etapas match y project
//        //creamos nuestras operaciones de pipeline, primero con $ match
//        Document match = new Document("$match", new Document("curso", "1ºDAM"));
//        //creamos el documento con la proyeccion
//        Document projectDocument = new Document("$project", new Document("nombre", 1).append("nota", 1));
//        //creamos la aggregation
//        List <Document> lista1 = Arrays.asList(match, projectDocument);
//        MongoCursor <Document> cursor1 = collection.aggregate(lista1).iterator();
//
//        System.out.println("Obtener el nombre y la nota de los alumnos de 1º DAM, utilizando las etapas match y project");
//        //recorremos el cursor
//        while(cursor1.hasNext()) {
//            Document alumno = cursor1.next();
//            System.out.println(alumno.toJson());
//        }
//        cursor1.close();
//
////        Calcular la suma y la nota media agrupada por curso.
////        El primer parámetro del grupo lo dejamos vacío.
//        //creamos nuestras operaciones de grupo, como no hay campo de agrupacion ponemos ""
//        // añadimos las operaciones
//        Document operac2 = new Document("_id", "")
//                .append("total", new Document("$sum", "$nota"))
//                .append("media", new Document("$avg", "$nota"));
//        //creamos el documento con $group
//        Document group2 = new Document("$group", operac2);
//        //creamos la aggregation
//        List <Document> lista2 = Arrays.asList(group2);
//        MongoCursor <Document> cursor2 = collection.aggregate(lista2).iterator();
//        System.out.println("Calcular la suma y la nota media agrupada por curso.");
//        //recorremos el cursor
//        while(cursor2.hasNext()) {
//            Document alumno = cursor2.next();
//            System.out.println(alumno.toJson());
//        }
//        cursor2.close();
//
//        ///Uso Etapa $out
//        //Si queremos guardar el resultado de la consulta en una nueva colección en la base de datos añadimos la etapa out.
//        //creamos nuestras operaciones de grupo, primero el campo por el que
//        //agrupamos y le añadimos las operaciones
//        Document operac3 = new Document("_id", "$curso")
//                .append("total", new Document("$sum", "$nota"))
//                .append("media", new Document("$avg", "$nota"));
//        //creamos el documento con $group
//        Document group3 = new Document("$group", operac3);
//        //creamos el documento de salida
//        Document salida = new Document("$out", "media");
//        //creamos la aggregation
//        List <Document> lista = Arrays.asList(group3, salida);
//        MongoCursor <Document> cursor3 = collection.aggregate(lista).iterator();
//        System.out.println("Mismo anterior. Uso Etapa $out");
//        //recorremos el cursor
//        while(cursor3.hasNext()) {
//            Document alumno = cursor3.next();
//            System.out.println(alumno.toJson());
//        }
//        cursor3.close();
//    }
//
//    public static void crear_borrarCol(){
//        //Crear una colección
//        // nos conectamos a MongoDB
//        MongoClient cliente = new MongoClient("localhost", 27017);
//        // nos conectamos a la base de datos
//        MongoDatabase db = cliente.getDatabase("centroeducativo");
//        //crear la collection
//        db.createCollection("nuevacollection");
//        //Borrar una colección
//        // nos conectamos a la base de datos
//        //obtenemos la collection
//        MongoCollection <Document> collection = db.getCollection("nuevacollection");
//        //borrar la collection
//        collection.drop();
//    }
//
//    public static void listarColBD(MongoDatabase db){
//        //metodo 1
//        System.out.println("Listado de las collectiones 1");
//        MongoIterable<String> collectiones = db.listCollectionNames();
//        Iterator col = collectiones.iterator();
//        while(col.hasNext()) {
//            System.out.println(col.next());
//        }
//        //metodo 2
//        System.out.println("==========================================");
//        System.out.println("Listado de las collectiones 2");
//        for(String nombre: db.listCollectionNames()) {
//            System.out.println(nombre);
//        }
//    }
}
