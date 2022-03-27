package Operations;

import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import java.util.logging.Level;

public class Update {
    public static void updateAuthorAddress(ODB odb) {
        System.out.println("*******UPDATE THE ADDRESS OF AN AUTHOR BY HIS DNI*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the dni the author: ");
        verifyDni(VerifyData.readDni(),odb);
    }

    private static void verifyDni(String dni, ODB odb) {
        Objects<Authors> author = QueryBD.queryDni(dni,odb);
        if (author.size() > 0) {
            Authors a1 = author.next();
            changeDirection(a1,odb);
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: The DNI entered not exists.");
        }
    }

    private static void changeDirection(Authors a, ODB odb) {
        System.out.print("1.-Enter the new address: ");
        a.setAddress(VerifyData.readString());
//        System.out.print("1.-Enter the new nationality: ");
//        a.setNationality(VerifyData.readName());
        odb.store(a);
    }


    public static void updateBookPrice(ODB odb) {
        String name, title;
        System.out.println("*******UPDATING THE PRICE OF THE BOOK*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the name the author: ");
        name = VerifyData.readName();
        System.out.print("2.-Enter the title the book: ");
        title = VerifyData.readName();
        verifyTitleAndNameAuthor(title,name,odb);
    }

    private static void verifyTitleAndNameAuthor(String title, String name, ODB odb) {
        Objects<Authors> author = QueryBD.queryTitleAndAuthor(title,name, odb);
        if (author.size() > 0) {
            Authors a1 = author.next();
            changePrice(a1, odb);
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: The book title or author name entered does not exist.");
        }
    }

    private static void changePrice(Authors a, ODB odb) {
        System.out.print("2.-Enter the new price: ");
        a.getBook().get(0).setPrice(VerifyData.readFloat());
        odb.store(a);
    }
}
