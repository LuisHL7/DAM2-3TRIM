package Operations;

import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import java.util.logging.Level;

public class Query {
    public static void queryAuthorsItalian(ODB odb) {
        System.out.println("*******AUTHORS OF ITALIAN NATIONALITY*******");
        System.out.println("==========================");
        showData(odb);
    }

    private static void showData(ODB odb) {
        Objects<Authors> author = QueryBD.queryAuthorItalian(odb);
        if (author.size() > 0) {
            int i = 1;
            while (author.hasNext()) {
                Authors aut = author.next();
                System.out.printf("%d: %s, %s, %s, %s, %s, %s. %n", i++, aut.getDni(), aut.getName(), aut.getAddress(), aut.getAge(), aut.getNationality(), aut.getBook());
            }
            System.out.println();
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: There are no authors of Italian nationality registered.");
        }
    }
}
