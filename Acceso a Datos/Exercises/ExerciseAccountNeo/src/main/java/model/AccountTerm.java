package model;

public class AccountTerm {
    private int interested;
    private String expirationDate;
    private float depositTerm;

    public AccountTerm() {
    }

    public AccountTerm(int interested, String expirationDate, float depositTerm) {
        this.interested = interested;
        this.expirationDate = expirationDate;
        this.depositTerm = depositTerm;
    }

    public int getInterested() {
        return interested;
    }

    public void setInterested(int interested) {
        this.interested = interested;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public float getDepositTerm() {
        return depositTerm;
    }

    public void setDepositTerm(float depositTerm) {
        this.depositTerm = depositTerm;
    }
}
