package Operations;

import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import java.util.logging.Level;

public class Delete {
    public static void deleteBookByIdAndAuthorName(ODB odb) {
        int id;
        String title;
        System.out.println("*******DELETE BOOK BY ITS ID AND BY THE NAME OF THE AUTHOR*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the name the author: ");
        id = VerifyData.readInt();
        System.out.print("2.-Enter the id the book: ");
        title = VerifyData.readName();
        verifyIdAndNameAuthor(id,title, odb);
    }

    private static void verifyIdAndNameAuthor(int id, String name, ODB odb) {
        Objects<Authors> author = QueryBD.queryIdAndAuthor(id,name, odb);
        if (author.size() > 0) {
            Authors a1 = author.next();
            deleteBook(a1, odb);
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: The book id or author name entered does not exist.");
        }
    }

    private static void deleteBook(Authors a, ODB odb) {
        odb.delete(a.getBook().get(0));
    }

}
