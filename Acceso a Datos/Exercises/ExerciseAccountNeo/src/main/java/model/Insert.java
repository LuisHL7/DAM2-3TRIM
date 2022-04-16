package model;

import connection.Client;
import operations.VerifyData;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;

public class Insert {

    public static void addAccountCurrent() {
        ODB odb = Client.connection();
        System.out.println("*******INSERT ACCOUNT CURRENT*******");
        Customer cus = addNewCustomerOrNo(odb);
        cus.getAccounts().add(insertAccountCurrent(new CurrentAccount()));
        odb.store(cus);
        odb.close();
        System.out.println("--> Inserted correctly");
    }

    public static void addAccountTerm() {
        ODB odb = Client.connection();
        System.out.println("*******INSERT ACCOUNT TERM*******");
        Customer cus = addNewCustomerOrNo(odb);
        cus.getAccounts().add(insertAccountTerm(new AccountTerm()));
        odb.store(cus);
        odb.close();
        System.out.println("--> Inserted correctly");
    }

    public static Customer addNewCustomerOrNo(ODB odb) {
        Customer cus;
        System.out.println("==========================");
        System.out.print("Do you want to create the account for a new customer?(Y/N): ");
        if (VerifyData.readAnswer().equalsIgnoreCase("Y")) {
            cus = addCustomer(odb);
        } else {

            cus = addAccountForCustomer(odb);
        }
        return cus;
    }

    public static Customer addCustomer(ODB odb) {
        Customer cus = new Customer();
        String dni;
        System.out.println("*******INSERT CUSTOMER*******");
        System.out.println("==========================");
        do {
            System.out.print("1.-Insert the dni: ");
            dni = VerifyData.readDni();
        } while (verifyDniRepeat(dni, odb));
        cus.setDni(dni);
        System.out.print("2.-Insert the name: ");
        cus.setName(VerifyData.readName());
        System.out.print("3.-Insert the address: ");
        cus.setAddress(VerifyData.readString());
        return cus;
    }

    private static boolean verifyDniRepeat(String dni, ODB odb) {
        boolean verify = false;
        if (QueryBD.queryDni(dni, odb).size() > 0) {
            VerifyData.logger.log(Level.SEVERE, "ERROR: The DNI entered exists.");
            verify = true;
        }
        return verify;
    }

    public static Customer addAccountForCustomer(ODB odb) {
        System.out.println("*******INSERT ACCOUNT FOR A CUSTOMER*******");
        System.out.println("==========================");
        System.out.print("1.-Enter the dni the customer: ");
        return verifyExistingDni(VerifyData.readDni(), odb);
    }

    private static Customer verifyExistingDni(String dni, ODB odb) {
        Objects<Customer> customerList = QueryBD.queryDni(dni, odb);
        if (customerList.size() == 0) {
            VerifyData.logger.log(Level.SEVERE, "ERROR: The DNI entered not exists.");
        }
        return customerList.next();
    }

    public static Account insertAccountCurrent(CurrentAccount account) {
        System.out.println("*******INSERT ACCOUNT*******");
        System.out.println("==========================");
        System.out.print("1.-Insert the branch: ");
        account.setBranch(VerifyData.readName());
        System.out.print("2.-Insert the current balance: ");
        account.setCurrentBalance(VerifyData.readFloat());

        return account;
    }

    public static Account insertAccountTerm(AccountTerm account) {
        System.out.println("*******INSERT ACCOUNT*******");
        System.out.println("==========================");
        System.out.print("1.-Insert the branch: ");
        account.setBranch(VerifyData.readName());
        System.out.print("2.-Insert the current balance: ");
        account.setCurrentBalance(VerifyData.readFloat());
        System.out.print("3.-Insert the interests: ");
        account.setInterested(VerifyData.readInt());
        System.out.print("4.-Insert the expiration date: ");
        account.setExpirationDate(VerifyData.readDate());
        System.out.print("5.-Insert the deposit term: ");
        account.setDepositTerm(VerifyData.readFloat());

        return account;
    }

    public static void addMovement() {
        Movement movement = new Movement();
        System.out.println("*******INSERT A MOVEMENT*******");
        System.out.println("==========================");
        ODB odb = Client.connection();
        System.out.print("1.-Insert the operation: (D=DEPOSIT or W=WITHDRAWAL or T= TRANSFER: ");
        char operation = VerifyData.readOperation().charAt(0);
        movement.setOperation(operation);
        if (operation == 'D' || operation == 'd') {
            odb.store(operationAutomaticTeller(odb, movement));
            odb.close();
        } else if (operation == 'W' || operation == 'w') {
            odb.store(operationAutomaticTeller(odb, movement));
            odb.close();
        } else {
            odb.close();
            addTransfer(movement);
        }
        System.out.println("--> Inserted correctly");


    }

    public static Customer operationAutomaticTeller(ODB odb, Movement movement) {
        Customer customer = askForNumber(odb, "2.-Enter the number the account: ");
        movement.setDate(new Date(new Date().getTime()));
        System.out.print("3.-Insert the imported: ");
        movement.setAmount(VerifyData.readFloat());
        if (movement.getOperation() == 'D' || movement.getOperation() == 'd') {
            movement.setResultingBalance(customer.getAccounts().get(0).getCurrentBalance() + movement.getAmount());
        } else {
            movement.setResultingBalance(customer.getAccounts().get(0).getCurrentBalance() - movement.getAmount());
        }
        customer.getAccounts().get(0).setCurrentBalance(movement.getResultingBalance());
        if (customer.getAccounts().get(0) instanceof CurrentAccount) {
            ((CurrentAccount) customer.getAccounts().get(0)).getMovements().add(movement);
        }
        return customer;
    }

    public static void addTransfer(Movement movement) {
        ODB odb = Client.connection();
        Customer account1 = askForNumber(odb, "2.-Enter the number the account: ");
        Customer account2 = askForNumber(odb, "3.-Enter the account number that the operation will receive: ");
        dataMovement(account1, account2, movement);
        odb.store(account1);
        odb.store(account2);
        odb.close();
    }

    public static void dataMovement(Customer account1, Customer account2, Movement movement) {
        Movement movement2 = new Movement();
        movement.setDate(new Date(new Date().getTime()));
        movement2.setDate(new Date(new Date().getTime()));
        movement2.setOperation(movement.getOperation());
        System.out.print("3.-Insert the imported: ");
        movement.setAmount(VerifyData.readFloat());
        movement2.setAmount(movement.getAmount());
        movement.setResultingBalance(account1.getAccounts().get(0).getCurrentBalance() - movement.getAmount());
        movement2.setResultingBalance(account2.getAccounts().get(0).getCurrentBalance() + movement2.getAmount());
        account1.getAccounts().get(0).setCurrentBalance(movement.getResultingBalance());
        account2.getAccounts().get(0).setCurrentBalance(movement2.getResultingBalance());
        if (account1.getAccounts().get(0) instanceof CurrentAccount && account2.getAccounts().get(0) instanceof CurrentAccount) {
            ((CurrentAccount) account1.getAccounts().get(0)).getMovements().add(movement);
            ((CurrentAccount) account2.getAccounts().get(0)).getMovements().add(movement2);
        }
    }

    private static Customer askForNumber(ODB odb, String text) {
        Customer account;
        boolean message = true;
        do {
            if (!message) {
                VerifyData.logger.log(Level.SEVERE, "ERROR: The entered number exists, but it is a term account.");
            }
            System.out.print(text);
            account = verifyExistingNumber(VerifyData.readInt(), odb);
        } while (message == !(account.getAccounts().get(0) instanceof CurrentAccount));
        return account;
    }

    private static Customer verifyExistingNumber(int number, ODB odb) {
        Objects<Customer> customerList = QueryBD.queryDataCustomer(odb);
        Customer customer = null;
        if (customerList.size() > 0) {
            while (customerList.hasNext()) {
                Customer cus = customerList.next();
                for (int j = 0; j < cus.getAccounts().size(); j++) {
                    if (cus.getAccounts().get(j).getNumber() == (number)) {
                        customer = cus;
                    }
                }
            }
        }
        return customer;
    }




    }
