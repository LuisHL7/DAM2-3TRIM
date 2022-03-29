package Operations;

import model.Authors;
import model.Books;
import org.neodatis.odb.*;

import java.util.logging.Level;

public class Insert {

    public static void addAuthor(ODB odb) {
        Authors a = new Authors();
        System.out.println("*******INSERT AUTHOR*******");
        System.out.println("==========================");
        String dni;
        do {
            System.out.print("1.-Insert the dni: ");
            dni = VerifyData.readDni();
        } while (verifyDniRepeat(dni,odb));
        a.setDni(dni);
        System.out.print("2.-Insert the name: ");
        a.setName(VerifyData.readName());
        System.out.print("3.-Insert the address: ");
        a.setAddress(VerifyData.readString());
        System.out.print("4.-Insert the age: ");
        a.setAge(VerifyData.readOptionAndAge());
        System.out.print("5.-Insert the nationality: ");
        a.setNationality(VerifyData.readName());
        addAnotherBook(a);
        odb.store(a);
    }

    public static void addBookForAuthor(ODB odb) {
        System.out.println("*******INSERT BOOK FOR A AUTHOR*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the dni the author: ");
        verifyExistingDni(VerifyData.readDni(),odb);
    }

    private static void verifyExistingDni(String dni, ODB odb) {
        Objects<Authors> author = QueryBD.queryDni(dni, odb);
        if (author.size() > 0) {
            Authors a = author.next();
            addAnotherBook(a);
            odb.store(a);
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: The DNI entered not exists.");
        }
    }

    private static boolean verifyDniRepeat(String dni, ODB odb) {
        boolean verify = false;
        if (QueryBD.queryDni(dni, odb).size() > 0) {
            VerifyData.logger.log(Level.SEVERE, "ERROR: The DNI entered exists.");
            verify = true;
        }
        return verify;
    }

    private static void addAnotherBook(Authors a) {
        String answer;
        do {
            a.getBook().add(insertBook());
            System.out.print("Would you like to add another book? Y/N: ");
            answer = VerifyData.readAnswer();
        } while (answer.equalsIgnoreCase("Y"));
    }

    public static Books insertBook() {
        Books b = new Books();
        System.out.println("*******INSERT BOOK*******");
        System.out.println("==========================");
        System.out.print("1.-Insert the title: ");
        b.setTitle(VerifyData.readName());
        System.out.print("2.-Insert the category: ");
        b.setCategory(VerifyData.readName());
        System.out.print("3.-Insert the price: ");
        b.setPrice(VerifyData.readFloat());
        System.out.print("4.-Insert date published: ");
        b.setDatePublished(VerifyData.readDate());
        return b;
    }
}
