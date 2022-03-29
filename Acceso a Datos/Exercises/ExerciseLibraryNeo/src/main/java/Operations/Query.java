package Operations;

import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;

import java.util.logging.Level;

public class Query {
    public static void queryAuthorsItalian(ODB odb) {
        System.out.println("*******AUTHORS OF ITALIAN NATIONALITY*******");
        System.out.println("==========================");
        showDataItalian(odb);
    }

    public static void queryAuthorSpanishLessThanSixty(ODB odb) {
        System.out.println("*******AUTHORS OF SPANISH NATIONALITY AND LESS THAN SIXTY*******");
        System.out.println("==========================");
        showDataSpanish(odb);
    }

    public static void queryNumberOfAuthorsByCountry(ODB odb) {
        System.out.println("*******NUMBER OF AUTHORS BY COUNTRY*******");
        System.out.println("==========================");
        showDataByCountry(odb);
    }

    public static void queryAuthorBookList(ODB odb) {
        String name;
        System.out.println("*******LIST OF BOOKS BY THE AUTHORS*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the name the author: ");
        name = VerifyData.readName();
        showDataAuthorBookList(odb,name);
    }

    public static void queryDataOfBookAndAuthor(ODB odb) {
        String title;
        System.out.println("*******FACTS OF A BOOK AND AUTHOR*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the title the book: ");
        title = VerifyData.readName();
        showDataOfBookAndAuthor(odb,title);
    }

    private static void showDataItalian(ODB odb) {
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

    private static void showDataSpanish(ODB odb) {
        Objects<Authors> author = QueryBD.queryAuthorSpanish(odb);
        if (author.size() > 0) {
            int i = 1;
            System.out.println("Nº\t\tName\t\tAge\t\tBook");
            System.out.println("--\t\t----\t\t---\t\t----");
            while (author.hasNext()) {
                Authors aut = author.next();
                System.out.println(i++ + "\t" + aut.getName() + "\t" + aut.getAge() + "\t" + aut.getBook());
            }
            System.out.println();
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: There are no authors of Spanish nationality and less than sixty registered.");
        }
    }

    private static void showDataByCountry(ODB odb) {
        Values values = QueryBD.queryNumberOfAuthorsByCountry(odb);
        if (values.size() > 0) {
            int i = 1;
            System.out.println("Nº\t\tCountry\t\tCount");
            System.out.println("--\t\t-------\t\t-----");
            while (values.hasNext()) {
                ObjectValues ov = values.next();
                System.out.println(i++ + "\t\t" + ov.getByIndex(0) + "\t\t" + ov.getByIndex(1));
            }
            System.out.println();
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: There is no registered author.");
        }
    }

    private static void showDataAuthorBookList(ODB odb, String name) {
        Objects<Authors> author = QueryBD.queryAuthorBookList(odb, name);
        if (author.size() > 0) {
            int i = 1;
            while (author.hasNext()) {
                Authors aut = author.next();
                System.out.println("Nº\t\t\tTitle\t\t\t\tPrice");
                System.out.println("--\t\t\t-----\t\t\t\t-----");
                for (int j = 0; j < aut.getBook().size() ;j++) {
                    System.out.println(i++ + "\t\t" + aut.getBook().get(j).getTitle() + "\t\t" + aut.getBook().get(j).getPrice());
                }
            }
            System.out.println();
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: There is no registered book.");
        }
    }

    private static void showDataOfBookAndAuthor(ODB odb, String title) {
        Objects<Authors> author = QueryBD.queryDataAuthors(odb);
        if (author.size() > 0) {
            int i = 1;
            System.out.println("Nº\t\t\tTitle\t\t\t\tCategory\t\t\t\tPrice\t\t\t\tDate Published\t\t\t\tAuthor");
            System.out.println("--\t\t\t-----\t\t\t\t--------\t\t\t\t-----\t\t\t\t--------------\t\t\t\t------");
            while (author.hasNext()) {
                Authors aut = author.next();
                for (int j = 0; j < aut.getBook().size() ;j++) {
                    if( aut.getBook().get(j).getTitle().equalsIgnoreCase(title)){
                        System.out.println(i++ + "\t\t" + aut.getBook().get(j).getTitle() + "\t\t" + aut.getBook().get(j).getCategory() +
                                "\t\t\t\t" + aut.getBook().get(j).getPrice() + "\t\t\t\t" + aut.getBook().get(j).getDatePublished() + "\t\t\t\t" + aut.getName());
                    }
                }
            }
            System.out.println();
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: There is no registered book.");
        }

    }
}
