package model;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Account implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int number;
    private String branch;
    private float currentBalance;
    private Set<Customer> customer;

    public Account() {
        number = count.incrementAndGet();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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

    @Override
    public String toString() {
        return "number=" + number +
                ", branch='" + branch + '\'' +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
