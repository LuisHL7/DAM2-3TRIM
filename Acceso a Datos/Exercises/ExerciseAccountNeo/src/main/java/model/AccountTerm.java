package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class AccountTerm extends Account implements Serializable {
    private int interested;
    private Date expirationDate;
    private float depositTerm;

    public AccountTerm() {
    }

    public int getInterested() {
        return interested;
    }

    public void setInterested(int interested) {
        this.interested = interested;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public float getDepositTerm() {
        return depositTerm;
    }

    public void setDepositTerm(float depositTerm) {
        this.depositTerm = depositTerm;
    }

    @Override
    public String toString() {
        return "AccountTerm{ " +
                super.toString() +
                "interested=" + interested +
                ", expirationDate=" + expirationDate +
                ", depositTerm=" + depositTerm +
                " }" ;
    }
}
