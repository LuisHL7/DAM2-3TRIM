package connection;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

public class Server {
    public static void main(String[] args) {
        // Crea el servidor en el puerto 8000
        ODBServer server  = ODBFactory.openServer(8000);
        //Crea BD si no existe y lo abre
        server.addBase("Accounts","neodatisServer.test");
        // Se inicia el servidor ejecutándose en segundo plano
        server.startServer(true);
        System.out.println("Server started....");
    }
}
