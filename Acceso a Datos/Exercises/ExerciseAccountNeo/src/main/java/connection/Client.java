package connection;

import model.Query;
import operations.Menu;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class Client {
    public static void main(String[] args) {
        ODB odb = null;
        try {
            odb = connection();
            Query.showDataClient(odb);
        } finally {
            if (odb != null)
                odb.close();
        }
        Menu.menuMain();
    }

    public static ODB connection() {
        return ODBFactory.openClient("localhost", 8000, "Accounts");
    }


}
