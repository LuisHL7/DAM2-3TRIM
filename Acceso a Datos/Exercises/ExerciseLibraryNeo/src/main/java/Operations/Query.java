package Operations;

import connection.Client;
import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;

import java.util.Date;
import java.util.logging.Level;

public class Query {
    public static void queryAuthorsItalian() {
        ODB odb = Client.connection();
        System.out.println("*******AUTHORS OF ITALIAN NATIONALITY*******");
        System.out.println("==========================");
        showDataItalian(odb);
        odb.close();
    }

    private static void showDataItalian(ODB odb) {
        Objects<Authors> author = QueryBD.queryAuthorItalian(odb);
        if (author.size() > 0) {
            AuthorList(author);
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: There are no authors of Italian nationality registered.");
        }
    }

    public static void queryBookBetweenDate() {
        ODB odb = Client.connection();
        String dni;
        Date firstDate, finalDate;
        System.out.println("*******LIST OF BOOKS BY THE AUTHORS BETWEEN DATES*******");
        System.out.println("==========================");
        do {
            System.out.print("1.-Insert the dni the author: ");
            dni = VerifyData.readDni();
        } while (verifyDni(dni,odb));
        System.out.print("2.-Enter the first date: ");
        firstDate = VerifyData.readDate();
        System.out.print("3.-Enter the final date: ");
        finalDate = VerifyData.readDate();
        showBookBetweenDate(odb,firstDate, finalDate, dni);
        odb.close();
    }

    private static boolean verifyDni(String dni, ODB odb) {
        boolean verify = false;
        Objects<Authors> author = QueryBD.queryDni(dni, odb);
        if (author.size() < 1) {
            VerifyData.logger.log(Level.SEVERE, "ERROR: The DNI entered not exists.");
            verify = true;
        }
        return verify;
    }

    private static void showBookBetweenDate(ODB odb, Date firstDate, Date finalDate, String dni) {
        Objects<Authors> author = QueryBD.queryDataAuthors(odb);
        if (author.size() > 0) {
            int i = 1;
            System.out.println("N??\t\t\tTitle\t\t\t\tCategory\t\t\t\tPrice\t\t\t\tDate Published\t\t\t\tAuthor");
            System.out.println("--\t\t\t-----\t\t\t\t--------\t\t\t\t-----\t\t\t\t--------------\t\t\t\t------");
            while (author.hasNext()) {
                Authors aut = author.next();
                for (int j = 0; j < aut.getBook().size() ;j++) {
                    if( aut.getDni().equalsIgnoreCase(dni) && aut.getBook().get(j).getDatePublished().after(firstDate) && aut.getBook().get(j).getDatePublished().before(finalDate)){
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

    public static void queryAuthorSpanishLessThanSixty() {
        ODB odb = Client.connection();
        System.out.println("*******AUTHORS OF SPANISH NATIONALITY AND LESS THAN SIXTY*******");
        System.out.println("==========================");
        showDataSpanish(odb);
        odb.close();
    }

    private static void showDataSpanish(ODB odb) {
        Objects<Authors> author = QueryBD.queryAuthorSpanish(odb);
        if (author.size() > 0) {
            int i = 1;
            System.out.println("N??\t\tName\t\tAge\t\tBook");
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

    public static void queryNumberOfAuthorsByCountry() {
        ODB odb = Client.connection();
        System.out.println("*******NUMBER OF AUTHORS BY COUNTRY*******");
        System.out.println("==========================");
        showDataByCountry(odb);
        odb.close();
    }

    private static void showDataByCountry(ODB odb) {
        Values values = QueryBD.queryNumberOfAuthorsByCountry(odb);
        if (values.size() > 0) {
            int i = 1;
            System.out.println("N??\t\tCountry\t\tCount");
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

    public static void queryAuthorBookList() {
        ODB odb = Client.connection();
        String name;
        System.out.println("*******LIST OF BOOKS BY THE AUTHORS*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the name the author: ");
        name = VerifyData.readName();
        showDataAuthorBookList(odb,name);
        odb.close();
    }

    private static void showDataAuthorBookList(ODB odb, String name) {
        Objects<Authors> author = QueryBD.queryAuthorBookList(odb, name);
        if (author.size() > 0) {
            int i = 1;
            while (author.hasNext()) {
                Authors aut = author.next();
                System.out.println("N??\t\t\tTitle\t\t\t\tPrice");
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

    public static void queryDataOfBookAndAuthor() {
        ODB odb = Client.connection();
        String title;
        System.out.println("*******FACTS OF A BOOK AND AUTHOR*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the title the book: ");
        title = VerifyData.readName();
        showDataOfBookAndAuthor(odb,title);
        odb.close();
    }

    private static void showDataOfBookAndAuthor(ODB odb, String title) {
        Objects<Authors> author = QueryBD.queryDataAuthors(odb);
        if (author.size() > 0) {
            int i = 1;
            System.out.println("N??\t\t\tTitle\t\t\t\tCategory\t\t\t\tPrice\t\t\t\tDate Published\t\t\t\tAuthor");
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

    public static void showDataAuthors(ODB odb) {
        Objects<Authors> author = QueryBD.queryDataAuthors(odb);
        if (author.size() > 0) {
            AuthorList(author);
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: Al cargar los datos.");
        }
    }

    private static void AuthorList(Objects<Authors> author) {
        int i = 1;
        System.out.println("N??\t\t\tDNI\t\t\t\tName\t\t\t\tAddress\t\t\t\t\tAge\t\t\t\tNationality\t\t\t\t\t\t\t\t\t\t\t\t\tBookList");
        System.out.println("--\t\t\t---\t\t\t\t----\t\t\t\t-------\t\t\t\t\t---\t\t\t\t-----------\t\t\t\t\t\t\t\t\t\t\t\t\t--------");
        while (author.hasNext()) {
            Authors aut = author.next();
            System.out.println(i++ + "\t\t" + aut.getDni() + "\t\t" + aut.getName() + "\t\t" + aut.getAddress() + "\t\t\t" + aut.getAge() + "\t\t\t\t" + aut.getNationality() + "\t\t\t\t" + aut.getBook());
        }
        System.out.println();
    }
}
