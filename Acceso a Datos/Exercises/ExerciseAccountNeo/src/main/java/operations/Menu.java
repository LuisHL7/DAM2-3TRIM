package operations;


import model.Delete;
import model.Insert;
import model.Query;
import model.Update;

import java.util.logging.Level;

public class Menu {
    public static void menuMain() {
        byte option;
        do {
            System.out.println("*******MENU ACCOUNT*******");
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
                case 1 -> insert();
                case 2 -> modify();
                case 3 -> delete();
                case 4 -> query();
                case 5 -> System.out.println("Closing the application");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 5);
    }

    public static void insert() {
        byte option;
        do {
            System.out.println("*******INSERT*******");
            System.out.println("==========================");
            System.out.println("1.-Register an account current");
            System.out.println("2.-Register an account term");
            System.out.println("3.-Register a movement");
            System.out.println("4.-Back to menu the application");
            System.out.print("Enter the option: ");
            option = VerifyData.readOptionAndAge();
            System.out.println();
            switch (option) {
                case 1 -> Insert.addAccountCurrent();
                case 2 -> Insert.addAccountTerm();
                case 3 -> Insert.addMovement();
                case 4 -> System.out.println("Backing to main menu");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 4);
    }


    private static void modify() {
        byte option;
        do {
            System.out.println("*******MODIFY*******");
            System.out.println("==========================");
            System.out.println("1.-Update the interests of an account Term");
            System.out.println("2.-Back to menu the application");
            System.out.print("Enter the option: ");
            option = VerifyData.readOptionAndAge();
            System.out.println();
            switch (option) {
                case 1 -> Update.updateInterestsAccountTerm();
                case 2 -> System.out.println("Backing to main menu");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 2);
    }

    private static void delete() {
        byte option;
        do {
            System.out.println("*******DELETE*******");
            System.out.println("==========================");
            System.out.println("1.-Deleting a term account");
            System.out.println("2.-Back to menu the application");
            System.out.print("Enter the option: ");
            option = VerifyData.readOptionAndAge();
            System.out.println();
            switch (option) {
                case 1 -> Delete.deleteTermAccount();
                case 2 -> System.out.println("Backing to main menu");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 2);
    }

    private static void query() {
        byte option;
        do {
            System.out.println("*******QUERY*******");
            System.out.println("==========================");
            System.out.println("1.-Displays all customers that their name starts with C");
            System.out.println("2.-Displays all customers whose current Account balance is > 200,000 euros.");
            System.out.println("3.-Shows the number of Customers who are in the red");
            System.out.println("4.-Display the average balance of the Term accounts of all the Clients of the bank");
            System.out.println("5.-Shows the movements performed on a current account between two specified dates.");
            System.out.println("6.-Back to menu the application");
            System.out.print("Enter the option: ");
            option = VerifyData.readOptionAndAge();
            System.out.println();
            switch (option) {
                case 1 -> Query.queryCustomerNameC();
                case 2 -> Query.queryAccountMinorBalance();
                case 3 -> Query.queryCountRedNumbers();
                case 4 -> Query.queryAverageTermAccount();
                case 5 -> Query.queryAccountBetweenDate();
                case 6 -> System.out.println("Backing to main menu");
                default -> VerifyData.logger.log(Level.SEVERE, "ERROR: Enter the option available");
            }
        } while (option != 6);
    }



}
