package model;

import java.io.Serializable;
import java.util.Date;

public class Movement implements Serializable {
    private Date date;
    private Account account;
    private char operation;
    private float amount;
    private float resultingBalance;

    public Movement() {
    }


    public Movement(Date date, char operation, float amount, float resultingBalance) {
        this.date = date;
        this.operation = operation;
        this.amount = amount;
        this.resultingBalance = resultingBalance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getResultingBalance() {
        return resultingBalance;
    }

    public void setResultingBalance(float resultingBalance) {
        this.resultingBalance = resultingBalance;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "date=" + date +
                ", operation=" + operation +
                ", amount=" + amount +
                ", resultingBalance=" + resultingBalance +
                '}';
    }
}
