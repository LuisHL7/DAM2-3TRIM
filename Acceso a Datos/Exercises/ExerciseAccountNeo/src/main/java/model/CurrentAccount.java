package model;

import java.util.List;
import java.util.Set;

public class CurrentAccount extends Account{
    private List<Movement> movements;

    public CurrentAccount() {
    }

    public CurrentAccount(int number, String brand, float currentBalance, Set<Customer> customer) {
        super(number, brand, currentBalance, customer);
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }
}
