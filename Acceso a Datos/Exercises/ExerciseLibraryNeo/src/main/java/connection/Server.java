package connection;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

public class Server {
    public static void main(String[] args) {
        ODBServer server = null;
        // Crea el servidor en el puerto 8000
        server = ODBFactory.openServer(8000);
        //Crea BD si no existe y lo abre
        server.addBase("BookStore","neodatisServer.test");
        // Se inicia el servidor ejecutándose en segundo plano
        server.startServer(true);
        System.out.println("Server started....");
    }
}
