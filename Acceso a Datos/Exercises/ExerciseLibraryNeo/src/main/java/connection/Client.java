package connection;

import Operations.Menu;
import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Client {
    public static void main(String[] args) {
        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BookStore");
            Objects<Authors> objects = odb.getObjects(Authors.class);
            System.out.printf("%d Authors: %n", objects.size());
            int i = 1;
            // visualizar los objetos
            while (objects.hasNext()) {
                Authors aut = objects.next();
                System.out.printf("%d %s, %s, %s, %s, %s, %s. %n", i++, aut.getDni(), aut.getName(), aut.getAddress(), aut.getAge(), aut.getNationality(), aut.getBook());
            }
            System.out.println();
            Menu.menuMain(odb);
        } finally {
            if (odb != null)
                odb.close();

        }

    }
}
