package Operations;

import org.neodatis.odb.ODB;

import java.util.logging.Level;

public class Menu {
    public static void menuMain(ODB odb) {
        byte option;
        do {
            System.out.println("*******MENU LIBRARY*******");
            System.out.println("==========================");
            System.out.println("1.-Insert data");
            System.out.println("2.-Modify data");
            System.out.println("3.-Delete data");
            System.out.println("4.-Query data");
            System.out.println("5.-Close the application");
            System.out.print("Enter the option: ");
            option = VerifyData.readOptionAndAge();
            System.out.println();
            switch (option) {
                case 1 -> insert(odb);
                case 2 -> modify(odb);
                case 3 -> delete(odb);
                case 4 -> query(odb);
                case 5 -> System.out.println("Closing the application");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 5);
    }

    public static void insert(ODB odb) {
        byte option;
        do {
            System.out.println("*******INSERT*******");
            System.out.println("==========================");
            System.out.println("1.-Enter an author with all their books.");
            System.out.println("2.-Adding a new book to an existing author.");
            System.out.println("3.-Back to menu the application");
            System.out.print("Enter the option: ");
            option = VerifyData.readOptionAndAge();
            System.out.println();
            switch (option) {
                case 1 -> Insert.addAuthor(odb);
                case 2 -> Insert.addBookForAuthor(odb);
                case 3 -> System.out.print("Backing to main menu");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 3);
    }

    private static void modify(ODB odb) {
        byte option;
        do {
            System.out.println("*******MODIFY*******");
            System.out.println("==========================");
            System.out.println("1.-Update an author's address by entering their DNI");
            System.out.println("2.-Updating the price of a given book, receiving the title and the name of the author.");
            System.out.println("3.-Back to menu the application");
            System.out.print("Enter the option: ");
            option = VerifyData.readOptionAndAge();
            System.out.println();
            switch (option) {
                case 1 -> Update.updateAuthorAddress(odb);
                case 2 -> Update.updateBookPrice(odb);
                case 3 -> System.out.println("Backing to main menu");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 3);
    }

    private static void delete(ODB odb) {
        byte option;
        do {
            System.out.println("*******DELETE*******");
            System.out.println("==========================");
            System.out.println("1.-Deleting a book, entering an author's name and book code.");
            System.out.println("2.-Back to menu the application");
            System.out.print("Enter the option: ");
            option = VerifyData.readOptionAndAge();
            System.out.println();
            switch (option) {
                case 1 -> Delete.deleteBookByIdAndAuthorName(odb);
                case 2 -> System.out.println("Backing to main menu");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 2);
    }

    private static void query(ODB odb) {
        byte option;
        do {
            System.out.println("*******QUERY*******");
            System.out.println("==========================");
            System.out.println("1.-Consultation of all authors whose nationality is Italian.");
            System.out.println("2.-Consultation of books written by a certain author between two dates.");
            System.out.println("3.-View all authors whose nationality is Spanish and their age be < 60 years old.");
            System.out.println("4.-View for each nation, the number of Authors.");
            System.out.println("5.-By entering the name of an author, we visualize all your books.");
            System.out.println("6.-Entering the title of a book visualize the data of the book.");
            System.out.println("7.-Back to menu the application");
            System.out.print("Enter the option: ");
            option = VerifyData.readOptionAndAge();
            System.out.println();
            switch (option) {
                case 1 -> Query.queryAuthorsItalian(odb);
                case 7 -> System.out.println("Backing to main menu");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 7);
    }



}
