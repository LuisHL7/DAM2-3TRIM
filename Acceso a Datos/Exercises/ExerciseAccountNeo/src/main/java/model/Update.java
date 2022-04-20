package model;

import connection.Client;
import operations.VerifyData;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import java.util.logging.Level;

public class Update {

    public static void updateInterestsAccountTerm() {
        Customer customer;
        ODB odb = Client.connection();
        int number;
        System.out.println("*******UPDATING THE INTERESTS OF ACCOUNT TERM*******");
        System.out.println("==========================");
        do {
            System.out.print("1.-Enter the dni the customer: ");
            customer = verifyDni(VerifyData.readDni(), odb);
        } while (customer == null);
        System.out.print("2.-Enter the number the account: ");
        number = VerifyData.readInt();
        for (int i = 0; i < customer.getAccounts().size(); i++) {
            if (customer.getAccounts().get(i).getNumber() == number) {
                if (customer.getAccounts().get(i) instanceof AccountTerm) {
                    System.out.print("3.-Enter the new interest: ");
                    ((AccountTerm) customer.getAccounts().get(i)).setInterested(VerifyData.readInt());
                } else {
                    VerifyData.logger.log(Level.SEVERE, "ERROR: The entered number exists, but it is a current account.");
                }
            }
        }
        odb.store(customer);
        odb.close();
        System.out.println("--> Updated correctly");
    }

    private static Customer verifyDni(String dni, ODB odb) {
        Objects<Customer> author = QueryBD.queryDni(dni, odb);
        Customer cus = null;
        if (author.size() > 0) {
            cus = author.next();
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: The DNI entered not exists.");
        }
        return cus;
    }
}

