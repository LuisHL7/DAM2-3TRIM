package Operations;

import java.util.logging.Level;

public class Menu {
    public static void menuMain() {
        byte option;
        do {
            System.out.println("*******MENU LIBRARY*******");
            System.out.println("==========================");
            System.out.println("1.-Insert data");
            System.out.println("2.-Modify data");
            System.out.println("2.-Delete data");
            System.out.println("3.-Query data");
            System.out.println("4.-Close the application");
            System.out.print("Enter the option: ");
            option = VerifyData.readOptionAndAge();
            switch (option) {
                case 1 -> insert();
                case 2 -> delete();
                case 3 -> query();
                case 4 -> System.out.println("Closing the application");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 4);
    }

    public static void insert() {
        byte option;
        do {
            System.out.println("*******INSERT*******");
            System.out.println("==========================");
            System.out.println("1.-A book by an author with all his books.");
            System.out.println("2.-Añadir un libro nuevo a un autor ya existente");
            System.out.println("3.-Back to menu the application");
            System.out.print("Enter the option: ");
            option = VerifyData.readOptionAndAge();
            switch (option) {
                case 1 -> Insert.insertAuthor();
                case 2 -> Insert.insertBook();
                case 3 -> System.out.println("Backing to main menu");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 3);



    }


}
