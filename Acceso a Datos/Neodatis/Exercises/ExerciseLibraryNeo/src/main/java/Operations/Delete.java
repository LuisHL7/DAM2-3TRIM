package Operations;

import connection.Client;
import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import java.util.logging.Level;

public class Delete {
    public static void deleteBookByIdAndAuthorName() {
        ODB odb = Client.connection();
        int id;
        String name;
        System.out.println("*******DELETE BOOK BY ITS ID AND BY THE NAME OF THE AUTHOR*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the name the author: ");
        name = VerifyData.readName();
        System.out.print("2.-Enter the id the book: ");
        id = VerifyData.readInt();
        deleteBook(id,name, odb);
    }

    private static void deleteBook(int id, String name, ODB odb) {
        Objects<Authors> author = QueryBD.queryDataAuthors(odb);
        if (author.size() > 0) {
            while (author.hasNext()) {
                Authors aut = author.next();
                for (int j = 0; j < aut.getBook().size(); j++) {
                    if (aut.getBook().get(j).getId() == (id) && aut.getName().equalsIgnoreCase(name)) {
                        odb.delete(aut.getBook().get(j));
                        odb.close();
                        System.out.println("--> Deleted correctly");
                    }
                }
            }
        } else {
            VerifyData.logger.log(Level.SEVERE,"ERROR: The book id or author name entered does not exist.");
        }
    }
}
