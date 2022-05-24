package model;

import connection.Client;
import operations.VerifyData;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import java.util.Date;
import java.util.logging.Level;

public class Query {
    public static void queryCustomerNameC() {
        ODB odb = Client.connection();
        System.out.println("*******CUSTOMERS NAME STARTS WITH C*******");
        System.out.println("==========================");
        showDataCustomerC(odb);
        odb.close();
    }

    public static void queryAccountMinorBalance() {
        ODB odb = Client.connection();
        System.out.println("*******ACCOUNT BALANCE IS > 200000€*******");
        System.out.println("==========================");
        showDataMinorBalance(odb);
        odb.close();
    }

    public static void queryCountRedNumbers() {
        ODB odb = Client.connection();
        System.out.println("*******CUSTOMERS ACCOUNT RED NUMBERS*******");
        System.out.println("==========================");
        showDataRedNumbers(odb);
        odb.close();
    }

    public static void queryAverageTermAccount() {
        ODB odb = Client.connection();
        System.out.println("*******AVERAGE TERM ACCOUNT*******");
        System.out.println("==========================");
        showDataAverageTermAccount(odb);
        odb.close();
    }

    private static void showDataCustomerC(ODB odb) {
        Objects<Customer> customer = QueryBD.queryCustomerNameWithC(odb);
        if (customer.size() > 0) {
            CustomerList(customer);
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: There are no customers whose name starts with the letter C.");
        }
    }

    private static void showDataMinorBalance(ODB odb) {
        Objects<Customer> customer = QueryBD.queryDataCustomer(odb);
        if (customer.size() > 0) {
            int i = 1;
            System.out.println("Nº\t\t\tDni\t\t\t\tName\t\t\t\tAddress\t\t\t\tCurrent Balance");
            System.out.println("--\t\t\t---\t\t\t\t----\t\t\t\t-------\t\t\t\t---------------");
            while (customer.hasNext()) {
                Customer cus = customer.next();
                for (int j = 0; j < cus.getAccounts().size(); j++) {
                    if (cus.getAccounts().get(j) instanceof CurrentAccount) {
                        if (cus.getAccounts().get(j).getCurrentBalance() > 200000) {
                            System.out.println(i++ + "\t\t" + cus.getDni() + "\t\t" + cus.getName() + "\t\t\t\t" + cus.getAddress() + "\t\t\t\t"
                                    + cus.getAccounts().get(j).getCurrentBalance());
                        }
                    }
                }
            }
            System.out.println();
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: There is no registered customer.");
        }
    }

    private static void showDataRedNumbers(ODB odb) {
        Objects<Customer> customer = QueryBD.queryDataCustomer(odb);
        int i = 0;
        if (customer.size() > 0) {
            System.out.println("Nº\t\t\tCUSTOMER");
            System.out.println("--\t\t\t--------");
            while (customer.hasNext()) {
                Customer cus = customer.next();
                for (int j = 0; j < cus.getAccounts().size(); j++) {
                    if (cus.getAccounts().get(j).getCurrentBalance() < 0) {
                        ++i;
                    }
                }
            }
            System.out.println("1\t\t" + i);
            System.out.println();
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: There is no registered customer.");
        }
    }

    private static void showDataAverageTermAccount(ODB odb) {
        Objects<Customer> customer = QueryBD.queryDataCustomer(odb);
        int cont = 0;
        float suma = 0;
        if (customer.size() > 0) {
            System.out.println("Nº\t\t\tTOTAL BALANCE");
            System.out.println("--\t\t\t-------------");
            while (customer.hasNext()) {
                Customer cus = customer.next();
                for (int j = 0; j < cus.getAccounts().size(); j++) {
                    if (cus.getAccounts().get(j) instanceof AccountTerm) {
                        suma +=  cus.getAccounts().get(j).getCurrentBalance();
                        ++cont;
                    }
                }
            }
            System.out.println("1\t\t" + suma/cont);
            System.out.println();
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: There is no registered customer.");
        }
    }


    public static void queryAccountBetweenDate() {
        ODB odb = Client.connection();
        Date firstDate, finalDate;
        System.out.println("*******LIST OF MOVEMENT BY THE CUSTOMER BETWEEN DATES*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the first date: ");
        firstDate = VerifyData.readDate();
        System.out.print("2.-Enter the final date: ");
        finalDate = VerifyData.readDate();
        showCurrentAccountBetweenDate(odb, firstDate, finalDate);
        odb.close();
    }

    private static void showCurrentAccountBetweenDate(ODB odb, Date firstDate, Date finalDate) {
        Objects<Customer> customer = QueryBD.queryDataCustomer(odb);
        if (customer.size() > 0) {
            int i = 1;
            System.out.println("Nº\t\t\tDate\t\t\t\tOperation\t\t\t\tAmount\t\t\t\tResulting Balance\t\t\t\tCustomer");
            System.out.println("--\t\t\t-----\t\t\t\t--------\t\t\t\t-----\t\t\t\t--------------\t\t\t\t------");
            while (customer.hasNext()) {
                Customer cus = customer.next();
                for (int j = 0; j < cus.getAccounts().size(); j++) {
                    if (cus.getAccounts().get(j) instanceof CurrentAccount) {
                        for (int k = 0; k < ((CurrentAccount) cus.getAccounts().get(j)).getMovements().size(); k++) {
                            if (((CurrentAccount) cus.getAccounts().get(j)).getMovements().get(k).getDate().after(firstDate) && ((CurrentAccount) cus.getAccounts().get(j)).getMovements().get(k).getDate().before(finalDate)) {
                                System.out.println(i++ + "\t\t" + ((CurrentAccount) cus.getAccounts().get(j)).getMovements().get(k).getDate() + "\t\t" + ((CurrentAccount) cus.getAccounts().get(j)).getMovements().get(k).getOperation() +
                                        "\t\t\t\t" + ((CurrentAccount) cus.getAccounts().get(j)).getMovements().get(k).getAmount() + "\t\t\t\t" + ((CurrentAccount) cus.getAccounts().get(j)).getMovements().get(k).getResultingBalance() + "\t\t\t\t" + cus.getName());
                            }
                        }
                    }
                }
            }
            System.out.println();
        } else {
            VerifyData.logger.log(Level.SEVERE, "ERROR: There is no registered customer.");
        }
    }

    public static void showDataClient(ODB odb) {
        Objects<Customer> customer = QueryBD.queryDataCustomer(odb);
        if (!customer.isEmpty()) {
            CustomerList(customer);
        } else {
            VerifyData.logger.log(Level.SEVERE, "Failed to load data");
        }
    }

    private static void CustomerList(Objects<Customer> customer) {
        int i = 1;
        System.out.println("Nº\t\t\tDNI\t\t\t\tName\t\t\t\tAddress\t\t\t\t\t\t\t\t\t\t\t\t\tCustomerList");
        System.out.println("--\t\t\t---\t\t\t\t----\t\t\t\t-------\t\t\t\t\t\t\t\t\t\t\t\t\t------------");
        while (customer.hasNext()) {
            Customer cus = customer.next();
            System.out.println(i++ + "\t\t" + cus.getDni() + "\t\t" + cus.getName() + "\t\t" + cus.getAddress() + "\t\t\t\t" + cus.getAccounts());
        }
        System.out.println();
    }
}
