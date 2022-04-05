package model;

import java.util.List;

public class Customer {
    private String dni;
    private String name;
    private String address;
    private List<Account> accounts;

    public Customer() {
    }

    public Customer(String dni, String name, String address) {
        this.dni = dni;
        this.name = name;
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
