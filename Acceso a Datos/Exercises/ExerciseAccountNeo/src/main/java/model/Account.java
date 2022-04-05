package model;

import java.util.Set;

public abstract class Account{
    private int number;
    private String brand;
    private float currentBalance;
    private Set<Customer> customer;

    public Account() {
    }

    public Account(int number, String brand, float currentBalance, Set<Customer> customer) {
        this.number = number;
        this.brand = brand;
        this.currentBalance = currentBalance;
        this.customer = customer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }
}
