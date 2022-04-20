package model;

import connection.Client;
import operations.VerifyData;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import java.util.logging.Level;

public class Delete {

    private static void deleteAccount(int number, String name, ODB odb) {
        Objects<Customer> customer = QueryBD.queryCustomerName(odb, name);
        if (customer.size() > 0) {
            while (customer.hasNext()) {
                Customer cus = customer.next();
                for (int i = 0; i < cus.getAccounts().size(); i++) {
                    if (cus.getAccounts().get(i).getNumber() == number) {
                        if (cus.getAccounts().get(i) instanceof AccountTerm) {
                            odb.delete(cus.getAccounts().get(i));
                            odb.close();
                            System.out.println("--> Deleted correctly");
                        } else {
                            VerifyData.logger.log(Level.SEVERE, "ERROR: The entered number exists, but it is a current account.");
                        }
                    }
                }
            }
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: The number or customer name entered does not exist.");
        }
    }

    public static void deleteTermAccount() {
        ODB odb = Client.connection();
        int number;
        String name;
        System.out.println("*******DELETE TERM ACCOUNT*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the name the customer: ");
        name = VerifyData.readName();
        System.out.print("2.-Enter the number the account: ");
        number = VerifyData.readInt();
        deleteAccount(number, name, odb);
    }
}
