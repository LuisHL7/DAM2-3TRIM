package connection;

import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
                System.out.printf("%d: %s, %s, %s, %n ,%s", i++, aut.getDni(), aut.getName(), aut.getAddress(),
                        aut.getAge(), aut.getNationality());
            }

        } finally {
            if (odb != null)
                odb.close();

        }
        LocalDate localDate = new LocalDate(new Date(localDate.getTime()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        localDate.format(formatter);

    }
}
