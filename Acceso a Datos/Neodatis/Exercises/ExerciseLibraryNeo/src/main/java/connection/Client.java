package connection;

import Operations.Menu;
import Operations.Query;
import Operations.QueryBD;
import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Client {
    public static void main(String[] args) {
        ODB odb = null;
        try {
            odb = connection();
            Query.showDataAuthors(odb);
        } finally {
            if (odb != null)
                odb.close();
        }
        Menu.menuMain();
    }

    public static ODB connection() {
        return ODBFactory.openClient("localhost", 8000, "BookStore");
    }


}
